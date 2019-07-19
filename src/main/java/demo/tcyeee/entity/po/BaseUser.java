package demo.tcyeee.entity.po;

import demo.tcyeee.entity.vo.BaseInfoVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;


/**
 * 基础用户信息类
 *
 * @author tcyeee
 */
@Data
@Entity
@Table(name = "base_user", schema = "demo_springCloud")
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

    /** #{@link enable} 是否可用 默认为1:可用*/
    @Column(name = "enable", nullable = false, length = 11, columnDefinition = "int(4) DEFAULT 1")
    private Integer enable;

    /** 手机号 */
    @Column(name = "mobilephone", unique = true, nullable = false, length = 12)
    private Integer mobilephone;

    /** 创建时间 */
    @Column(name = "createdate", columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    private String username;            // 昵称
    private String password;            // 密码
    private String signature;           // 签名
    private Integer userType;           // 用户类型
    private Date lastPasswordReset;     // 用户上次登录时间

    @Transient
    private String authoritiesString;   // 验证字段




    public BaseUser creatBaseUser(BaseInfoVo vo) {
        BaseUser baseUser = new BaseUser();
        baseUser.setMobilephone(vo.getMobilephone());
        baseUser.setPassword(vo.getPassword());
        return baseUser;
    }

    @Getter
    @AllArgsConstructor
    public enum enable {
        zero(0, "账号已经注销,现在不可用"),
        one(1, "可以正常使用");

        private int enable;
        private String remark;
    }
}