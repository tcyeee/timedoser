package com.timedoser.cloud.common.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.Date;


/**
 * 基础用户信息类
 *
 * @author tcyeee
 */
@Data
public class AclUser implements Serializable {
    private static final long serialVersionUID = 7080456749403365766L;
    private String id;
    private String email;
    private String openid;
    private enableTypeEnum enable;
    private String mobilephone;
    private Date createdate;
    private accountTypeEnum accountType;
    private String username;            // 昵称
    private String avatarUrl;           // 头像地址
    private String password;            // 密码
    private String signature;           // 签名
    private Date lastPasswordReset;     // 用户上次登录时间
    private Integer gender;             // 性别
    private String country;             // 国家
    private String province;            // 省
    private String city;                // 市

    // 账户状态
    @Getter
    @AllArgsConstructor
    public enum enableTypeEnum {
        err(0, "弃用位置"),
        defult(1, "可以正常使用"),
        two(2, "账号已经注销,现在不可用");

        private int index;
        private String remark;
    }

    // 账户注册类型
    @Getter
    @AllArgsConstructor
    public enum accountTypeEnum {
        err(0, "弃用位置"),
        defult(1, "小程序用户, 只有openid, 没有注册"),
        two(2, "手机号注册用户"),
        author(3, "作者账户"),
        Administrator(4, "管理员账户");

        private int index;
        private String remark;
    }

    @Tolerate
    public AclUser() {
    }
}