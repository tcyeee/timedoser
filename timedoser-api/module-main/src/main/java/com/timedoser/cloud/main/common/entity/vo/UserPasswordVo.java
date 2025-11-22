package com.timedoser.cloud.main.common.entity.vo;

import lombok.Data;

/**
 * @author huxiong
 * @date 2020/6/18 17:38
 */
@Data
public class UserPasswordVo {
    private String id;
    private String email;                  // 邮箱
    private String mobilephone;            // 手机号
    private String username;               // 昵称
    private String personalizedSignature;  // 个性签名
    private String avatar;                 // 头像地址

    private String authoritiesString;      // 角色列表
    private String token;                  // 角色列表
    private Integer enable;                // 账户状态
}
