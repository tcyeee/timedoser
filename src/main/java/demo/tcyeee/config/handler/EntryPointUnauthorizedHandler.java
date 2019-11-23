package demo.tcyeee.config.handler;

import demo.tcyeee.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static demo.tcyeee.utils.ResponseUtils.LOGIN_ERROR_MSG;


/**
 * 未登录或无权限时触发操作
 *
 * @author tcyeee
 * @date 2019-05-08 16:15:01
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        String info = ResponseUtils.creatErrResponse(ResponseUtils.ReturnCode.PERMISSION_DISABLE, LOGIN_ERROR_MSG);
        httpServletResponse.getWriter().println(info);
        httpServletResponse.getWriter().flush();
    }

}
