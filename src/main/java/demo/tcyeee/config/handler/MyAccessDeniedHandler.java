package demo.tcyeee.config.handler;

import demo.tcyeee.entity.base.ReturnInfo;
import demo.tcyeee.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 无权限访问时触发
 *
 * @author tcyeee
 * @date 2019-05-08
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    /* 状态信息 */
    static private final String ERROR_MSG = "权限不够";

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {

        //返回json形式的错误信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        ReturnInfo info = ReturnInfo.markCustom(false, ReturnInfo.ReturnCode.API_DISABLE.getCode(), ReturnInfo.ReturnCode.API_DISABLE.getMsg(), ERROR_MSG);
        httpServletResponse.getWriter().println(ResponseUtils.creatResponse(info));
        httpServletResponse.getWriter().flush();
    }
}
