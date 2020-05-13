package com.timedoser.cloud.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.timedoser.cloud.utils.ResponseUtils.creatJsonResponse;


/**
 * @author tcyeee
 * @since 2019-08-11 09:45
 */
@RestController
@RequestMapping("user")
public class UserController {

//    @Resource
//    private UserService userService;
//
//    /**
//     * 小程序用户通过授权以后,更新数据库中基础用户数据
//     *
//     * @return data
//     */
//    @RequestMapping("updateUserInfo")
//    public String updateUserInfo(String userInfo) {
//        if (StringUtils.isBlank(userInfo) || "null".equals(userInfo)) return creatErrResponse(PARAMS_ERROR_INFO);
//        return creatJsonResponse(userService.updataUserInfo(userInfo));
//    }


    @GetMapping("findOne")
    public String findOneById(String userId) {
        return null;
    }
}
