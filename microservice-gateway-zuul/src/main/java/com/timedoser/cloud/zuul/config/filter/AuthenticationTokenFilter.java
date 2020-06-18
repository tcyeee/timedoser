package com.timedoser.cloud.zuul.config.filter;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.enums.StatusCode;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.common.utils.BaseUtils;
import com.timedoser.cloud.zuul.common.entity.TokenDetail;
import com.timedoser.cloud.zuul.common.utils.TokenUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 配置在 Spring Security 的配置类中
 * 用于解析 token ，将用户所有的权限写入本次 Spring Security 的会话中
 *
 * @author tcyeee
 * @date 2020年06月06日
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
    final private String tokenHeader = "token";

    @Resource
    private TokenUtils tokenUtils;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(tokenHeader);
        AclUser user = BaseUtils.userInfo();

        // 如果上面解析 token 成功并且拿到了 username 并且本次会话的权限还未被写入
        if (user != null && user.getId() != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            ((HttpServletRequest) request).getSession().setAttribute("userInfo", user);
            UserDetails userDetails = new TokenDetail(user);

            // token校验无误则将权限写入本次会话
            if (tokenUtils.validateToken(authToken, user)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            // 如果账户被禁用
            if (!userDetails.isEnabled()) {
                response.getWriter().print(Result.error(StatusCode.ACCOUNT_ERROR));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
