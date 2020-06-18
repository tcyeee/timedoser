package com.timedoser.cloud.zuul.config;

import com.timedoser.cloud.zuul.config.filter.AuthenticationTokenFilter;
import com.timedoser.cloud.zuul.config.handler.EntryPointUnauthorizedHandler;
import com.timedoser.cloud.zuul.config.handler.MyAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Spring Security 的配置类
 *
 * @author tcyeee
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册 401 处理器
     */
    @Resource
    private EntryPointUnauthorizedHandler unauthorizedHandler;

    /**
     * 注册 403 处理器
     */
    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;

    /**
     * 注册 token 转换拦截器为 bean
     * 如果客户端传来了 token ，那么通过拦截器解析 token 赋予用户权限
     * <p>
     * 后期如果出现了设备同时登录数量限制 或者记住密码之类的需求可以直接在这里配置
     */
    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/message").hasAuthority("admin")         // 需拥有 admin 这个权限
//                .antMatchers("/message").hasRole("admin")              // 需拥有 ADMIN 这个身份
                .antMatchers("/main/login/**").permitAll()  // login目录下可以访问
                .anyRequest().authenticated()                            // 允许所有认证请求通过
                .and().exceptionHandling()                               // 配置被拦截时的处理
                .authenticationEntryPoint(this.unauthorizedHandler)      // 添加 token 无效或者没有携带 token 时的处理
                .accessDeniedHandler(this.accessDeniedHandler)           // 添加无权限时的处理
                .and().csrf().disable()                                  // 禁用 Spring Security 自带的跨域处理
                .sessionManagement()                                     // 定制我们自己的 session 策略
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 调整为让 Spring Security 不创建和使用 session


        /*
         * 本次 json web token 权限控制的核心配置部分
         * 在 Spring Security 开始判断本次会话是否有权限时的前一瞬间
         * 通过添加过滤器将 token 解析，将用户所有的权限写入本次会话
         */
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        /*
         *  禁用缓存
         */
        http.headers().cacheControl();
    }
}
