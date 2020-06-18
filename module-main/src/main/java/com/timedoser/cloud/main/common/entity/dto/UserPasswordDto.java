package com.timedoser.cloud.main.common.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author huxiong
 * @date 2020/6/18 16:15
 */
@Data
public class UserPasswordDto {

    @NotBlank(message = "phoneNumber不可为空!")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phoneNumber;

    @NotBlank(message = "password不可为空!")
    private String password;
}

