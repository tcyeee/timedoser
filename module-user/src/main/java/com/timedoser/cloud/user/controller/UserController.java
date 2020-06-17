package com.timedoser.cloud.user.controller;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;


/**
 * @author tcyeee
 * @since 2019-08-11 09:45
 */
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 通过手机号查看用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    @GetMapping("findUserByPhone")
    public Result findUserByPhone(String phoneNumber) {
        return Result.ok(userService.findUserByPhone(phoneNumber));
    }

    @GetMapping("getInfo")
    public Result getInfo(@NotBlank String id) {
        return Result.ok(userService.getInfo(id));
    }
}
