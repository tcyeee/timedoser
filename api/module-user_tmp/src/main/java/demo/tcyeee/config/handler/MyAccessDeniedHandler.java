package demo.tcyeee.config.handler;

import demo.tcyeee.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static demo.tcyeee.utils.ResponseUtils.ACCESS_ERROR_MSG;


/**
 * 无权限访问时触发
 *
 * @author tcyeee
 * @date 2019-05-08
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        String info = ResponseUtils.creatErrResponse(ResponseUtils.ReturnCode.PERMISSION_DISABLE, ACCESS_ERROR_MSG);
        httpServletResponse.getWriter().println(info);
        httpServletResponse.getWriter().flush();
    }
}
