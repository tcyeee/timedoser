package com.timedoser.cloud.user.controller;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;


/**
 * @author tcyeee
 * @since 2019-08-11 09:45
 */
@Validated
@RestController
@RequestMapping("user")
public class AclUserController {

    @Resource
    private UserService userService;

    /**
     * 通过手机号查看用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    @GetMapping("findUserByPhone")
    public BaseUser findUserByPhone(@NotBlank String phoneNumber) {
        return userService.findUserByPhone(phoneNumber);
    }

    @PostMapping("getInfo")
    public Result getInfo(@RequestBody StatusDto param) {
        return Result.page(userService.selectPageVo(param));
    }
}
