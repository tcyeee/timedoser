package com.timedoser.cloud.main.common.entity.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author huxiong
 * @date 2020/6/18 16:15
 */
@Data
public class UserPasswordVo {

    @NotBlank(message = "phoneNumber不可为空!")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @Max(value = 11, message = "手机号只能为{max}位")
    @Min(value = 11, message = "手机号只能为{min}位")
    private String phoneNumber;

    @NotBlank(message = "password不可为空!")
    private String password;
}

