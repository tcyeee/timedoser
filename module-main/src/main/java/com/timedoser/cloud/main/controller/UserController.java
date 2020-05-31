package com.timedoser.cloud.main.controller;

import com.timedoser.cloud.main.server.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.timedoser.cloud.common.utils.ResponseUtils.creatJsonResponse;

/**
 * @author tcyeee
 * @since 2020/5/31 3:08 下午
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("findUserByPhone")
    public String findUserByPhone(String phoneNumber) {
        return creatJsonResponse(userFeignClient.findUserByPhone(phoneNumber));
    }

}
