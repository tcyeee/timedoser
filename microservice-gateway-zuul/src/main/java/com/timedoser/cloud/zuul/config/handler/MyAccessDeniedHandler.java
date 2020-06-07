//package com.timedoser.cloud.zuul.config.handler;
//
//import com.timedoser.cloud.common.entity.base.Result;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * 无权限访问时触发
// *
// * @author tcyeee
// * @date 2019-05-08
// */
//@Component
//public class MyAccessDeniedHandler implements AccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
//        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setContentType("application/json");
//        httpServletResponse.getWriter().println(Result.error(HttpStatus.FORBIDDEN));
//        httpServletResponse.getWriter().flush();
//    }
//}
