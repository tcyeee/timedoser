package com.timedoser.cloud.common.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 基础用户信息类
 *
 * @author tcyeee
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 7080456749403365766L;
    private String id;
    private String email;
    private String openid;
    private Integer enable;
    private String mobilephone;
    private Date createdate;
    private Integer accountType;
    private String username;            // 昵称
    private String avatarUrl;           // 头像地址
    private String password;            // 密码
    private Date lastPasswordReset;     // 用户上次登录时间
    private Integer gender;             // 性别
    private String country;             // 国家
    private String province;            // 省
    private String city;                // 市
}