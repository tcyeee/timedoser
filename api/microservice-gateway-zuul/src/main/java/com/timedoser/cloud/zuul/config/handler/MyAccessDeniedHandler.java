package com.timedoser.cloud.zuul.config.handler;

import cn.hutool.json.JSONUtil;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.enums.StatusCode;
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
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(JSONUtil.toJsonStr(Result.error(StatusCode.NO_ACCESS)));
        response.getWriter().flush();
    }
}
