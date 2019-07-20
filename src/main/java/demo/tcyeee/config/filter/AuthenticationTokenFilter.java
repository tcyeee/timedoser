package demo.tcyeee.config.filter;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.ReturnInfo;
import demo.tcyeee.entity.base.TokenDetail;
import demo.tcyeee.entity.enums.base.ReturnCodeList;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.BaseInfoVo;
import demo.tcyeee.service.BaseService;
import demo.tcyeee.utils.ResponseUtils;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
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
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${token.header}")
    private String tokenHeader;

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private BaseUserDao userDao;

    @Resource
    private BaseService baseService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        // 将 ServletRequest 转换为 HttpServletRequest 才能拿到请求头中的 token
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 尝试获取请求头的 token
        String authToken = httpRequest.getHeader(this.tokenHeader);
        // 尝试拿 token 中的 username
        // 若是没有 token 或者拿 username 时出现异常，那么 username 为 null
        Integer mobilephone = this.tokenUtils.getMobilephoneFromToken(authToken);

        // 如果上面解析 token 成功并且拿到了 username 并且本次会话的权限还未被写入
        if (mobilephone != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // 用 UserDetailsService 从数据库中拿到用户的 UserDetails 类
            // UserDetails 类是 Spring Security 用于保存用户权限的实体类
            BaseUser userInfo = userDao.findByMobilephone(mobilephone);
            BaseInfoVo baseUserInfo = baseService.findByPhone(mobilephone);

            // userInfo存入session
            ((HttpServletRequest) request).getSession().setAttribute("userInfo", baseUserInfo);
            UserDetails userDetails = new TokenDetail(userInfo);

            // 检查用户带来的 token 是否有效
            // 包括 token 和 userDetails 中用户名是否一样， token 是否过期， token 生成时间是否在最后一次密码修改时间之前
            // 若是检查通过
            if (this.tokenUtils.validateToken(authToken, userDetails)) {
                // 生成通过认证
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                // 将权限写入本次会话
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }


            if (!userDetails.isEnabled()) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                String info = ResponseUtils.creatResponse(ReturnInfo.markCustom(false, ReturnCodeList.ACCOUNT_ERROR.getCode(), ReturnCodeList.ACCOUNT_ERROR.getCode(), ""));
                response.getWriter().print(info);
                return;
            }
        }

        chain.doFilter(request, response);
    }


}
