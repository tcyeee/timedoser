package com.timedoser.cloud.zuul.config.handler;

import cn.hutool.json.JSONUtil;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.enums.StatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

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
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(JSONUtil.toJsonStr(Result.error(StatusCode.NO_LOGIN)));
        response.getWriter().flush();
    }
}
