package demo.tcyeee.config.handler;

import demo.tcyeee.entity.base.ReturnInfo;
import demo.tcyeee.entity.enums.base.ReturnCodeList;
import demo.tcyeee.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录或无权限时触发操作
 *
 * @author tcyeee
 * @date 2019-05-08 16:15:01
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    /* 状态信息 */
    static private final String ERROR_MSG = "token无效";

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        ReturnInfo info = ReturnInfo.markCustom(false, ReturnCodeList.API_DISABLE.getCode(), ReturnCodeList.API_DISABLE.getMsg(), ERROR_MSG);
        httpServletResponse.getWriter().println(ResponseUtils.creatResponse(info));

        httpServletResponse.getWriter().flush();
    }

}
