package demo.tcyeee.entity.po;

import demo.tcyeee.utils.BaseUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


/**
 * 基础用户信息类
 *
 * @author tcyeee
 */
@Data
@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@Table(name = "base_user")
public class BaseUser {

    @Id
    @Column(unique = true, nullable = false, length = 100, updatable = false)
    private String id;

    // 邮箱
    @Column(unique = true, length = 30)
    private String email;

    // [小程序]唯一id
    @Column(unique = true, length = 100)
    private String openid;

    // 账户状态
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private enableTypeEnum enable;

    // 手机号
    @Column(unique = true, length = 11)
    private String mobilephone;

    // 创建时间
    @Column(columnDefinition = "timestamp DEFAULT current_timestamp")
    private Date createdate;

    // 用户类型
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 1")
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

    @Transient
    private String authoritiesString;   // 验证字段


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
    public BaseUser() {
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
                .id(BaseUtils.getUuid())
                .signature(BaseUtils.getSignature())
                .accountType(accountTypeEnum.defult)
                .enable(enableTypeEnum.defult).build();
    }
}