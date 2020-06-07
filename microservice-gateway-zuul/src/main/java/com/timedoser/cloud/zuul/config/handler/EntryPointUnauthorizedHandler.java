//package com.timedoser.cloud.zuul.config.handler;
//
//import com.timedoser.cloud.common.entity.base.Result;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * 未登录或无权限时触发操作
// *
// * @author tcyeee
// * @date 2019-05-08 16:15:01
// */
//@Component
//public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("application/json");
//        httpServletResponse.getWriter().println(Result.error(HttpStatus.UNAUTHORIZED));
//        httpServletResponse.getWriter().flush();
//    }
//}
