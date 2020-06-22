package com.timedoser.cloud.main.controller.account;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.main.server.IUserServer;
import com.timedoser.cloud.main.server.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @since 2020/5/31 3:08 下午
 */
//@CrossOrigin
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private IUserServer userServer;

    @GetMapping("findUserByPhone")
    public Result findUserByPhone(String phoneNumber) {
        return Result.ok(userFeignClient.findUserByPhone(phoneNumber));
    }

    /**
     * 获取个人信息
     *
     * @return userinfo
     */
    @GetMapping("userInfo")
    public Result userInfo() {
        return Result.ok(userServer.userInfo());
    }
}
