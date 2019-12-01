package demo.tcyeee.config.filter;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.TokenDetail;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.mapper.UserMapper;
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

import static demo.tcyeee.utils.ResponseUtils.ACCESS_ERROR_MSG;

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
    private UserMapper userMapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(this.tokenHeader);
        String userId = tokenUtils.getIdFromToken(authToken);

        // 如果上面解析 token 成功并且拿到了 username 并且本次会话的权限还未被写入
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            BaseUser userInfo = userDao.findByUserId(userId);
            userInfo.setAuthoritiesString(userMapper.getRoles(userId));
            ((HttpServletRequest) request).getSession().setAttribute("userInfo", userInfo);

            UserDetails userDetails = new TokenDetail(userInfo);

            // token校验无误则将权限写入本次会话
            if (tokenUtils.validateToken(authToken, userInfo)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            if (!userDetails.isEnabled()) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                String info = ResponseUtils.creatErrResponse(ResponseUtils.ReturnCode.PERMISSION_DISABLE, ACCESS_ERROR_MSG);
                response.getWriter().print(info);
                return;
            }
        }
        chain.doFilter(request, response);
    }


}
