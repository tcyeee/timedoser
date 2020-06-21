package com.timedoser.cloud.main.controller.account;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import com.timedoser.cloud.main.server.LoginServer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录相关
 *
 * @author huxiong
 * @date 2020/6/18 16:11
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginServer loginServer;

    /**
     * 通过账号密码登录
     *¥
     * @param param param登录参数
     * @return {@link Result
     */
    @PostMapping("userPassword")
    public Result userPassword(@Validated @RequestBody UserPasswordDto param) {
        return loginServer.userPassword(param);
    }
}
