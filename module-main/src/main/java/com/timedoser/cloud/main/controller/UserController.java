package com.timedoser.cloud.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tcyeee
 * @since 2020/5/31 3:08 下午
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("findUserByPhone")
    public String findUserByPhone(String phoneNumber) {
        return "sure" + phoneNumber;
    }

}
