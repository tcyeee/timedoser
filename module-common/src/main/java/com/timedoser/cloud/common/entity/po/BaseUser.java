package com.timedoser.cloud.common.entity.po;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * 基础用户信息类
 *
 * @author tcyeee
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseUser implements Serializable {
    private static final long serialVersionUID = 7080456749403365766L;
    private String id;
    private String email;                  // 邮箱
    private String openid;                 // [小程序]唯一id
    private Integer enable;                // 账户状态
    private String mobilephone;            // 手机号
    private Date createdate;               // 创建时间
    private Integer accountType;           // 用户类型
    private String username;               // 昵称
    private String avatarUrl;              // 头像地址
    private String password;               // 密码
    private Date lastPasswordReset;        // 用户上次登录时间
    private Integer gender;                // 性别
    private String country;                // 国家
    private String province;               // 省
    private String city;                   // 市
    private String personalizedSignature;  // 个性签名

    @TableField(exist = false)
    private String authoritiesString;   // 角色列表


    // 账户状态
    @Getter
    @AllArgsConstructor
    public enum enableTypeEnum {
        err(0, "弃用位置"),
        defult(1, "可以正常使用"),
        two(2, "账号已经注销,现在不可用");

        private final int index;
        private final String remark;
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

        private final int index;
        private final String remark;
    }

    /**
     * 微信首次登录通过appcode添加一条用户记录
     *
     * @param openid openId
     * @return data
     */
    public static BaseUser creatBaseUserForOpenId(String openid) {
        return BaseUser.builder()
                .openid(openid)
                .createdate(new Date())
                .id(IdUtil.fastSimpleUUID())
                .accountType(accountTypeEnum.defult.index)
                .enable(enableTypeEnum.defult.index).build();
    }
}