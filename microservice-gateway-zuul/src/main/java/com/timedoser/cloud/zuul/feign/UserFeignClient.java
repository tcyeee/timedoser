//package com.timedoser.cloud.zuul.feign;
//
//import com.timedoser.cloud.common.entity.po.AclUser;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * Feign的fallback测试
// * 使用@FeignClient的fallback属性指定回退类
// */
//@FeignClient(name = "module-user")
//public interface UserFeignClient {
//
//    @RequestMapping(value = "/user/findUserByPhone", method = RequestMethod.GET)
//    AclUser findUserByPhone(@RequestParam("phoneNumber") String phoneNumber);
//}