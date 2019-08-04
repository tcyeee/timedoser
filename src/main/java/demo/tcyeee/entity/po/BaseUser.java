package demo.tcyeee.entity.po;

import demo.tcyeee.entity.vo.WeixinUserInfoVo;
import demo.tcyeee.utils.BaseUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;

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
@Table(name = "base_user")
public class BaseUser {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 200, updatable = false)
    private String userId;

    /** 邮箱 */
    @Column(name = "email", unique = true, length = 200)
    private String email;

    /** [小程序]唯一id */
    @Column(name = "openid", unique = true, length = 200)
    private String openid;

    /** #{@link enableTypeEnum} 是否可用 默认为1*/
    @Column(name = "enable", nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private Integer enable;

    /** 手机号 */
    @Column(name = "mobilephone", unique = true, length = 12)
    private Integer mobilephone;

    /** 创建时间 */
    @Column(name = "createdate", columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    /** #{@link accountTypeEnum} 用户类型 */
    @Column(name = "account_type", nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private Integer accountType;

    private String username;            // 昵称
    private String avatarUrl;           // 头像地址
    private String password;            // 密码
    private String signature;           // 签名
    private Date lastPasswordReset;     // 用户上次登录时间
    private String userToken;           // 用户存根

    private Integer gender;             // 性别
    private String country;             // 国家
    private String province;            // 省
    private String city;                // 市

    @Transient
    private String authoritiesString;   // 验证字段


    /** 账户是否删除, 默认为1 */
    @Getter
    @AllArgsConstructor
    public enum enableTypeEnum {
        defult(1, "可以正常使用"),
        two(2, "账号已经注销,现在不可用");

        private int type;
        private String remark;
    }

    /** 账户注册类型 */
    @Getter
    @AllArgsConstructor
    public enum accountTypeEnum {
        one(1, "小程序用户, 只有openid, 没有注册"),
        two(2, "手机号注册用户"),
        author(99, "作者账户"),
        Administrator(98, "管理员账户");

        private int type;
        private String remark;
    }

    @Tolerate
    public BaseUser() {}

    /**
     * 微信首次登录通过appcode添加一条用户记录
     *
     * @param openid openId
     * @param vo     微信开放的用户信息
     * @return data
     */
    public static BaseUser creatBaseUserForOpenId(String openid, WeixinUserInfoVo vo) {
        return BaseUser.builder()
                .openid(openid)
                .city(vo.getCity())
                .createdate(new Date())
                .gender(vo.getGender())
                .country(vo.getCountry())
                .province(vo.getProvince())
                .username(vo.getNickName())
                .userId(BaseUtils.getUuid())
                .avatarUrl(vo.getAvatarUrl())
                .accountType(accountTypeEnum.one.type)
                .enable(enableTypeEnum.defult.type).build();
    }
}