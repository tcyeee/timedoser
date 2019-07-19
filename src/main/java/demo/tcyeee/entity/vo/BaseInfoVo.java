package demo.tcyeee.entity.vo;

import lombok.Data;

/**
 * 登录返回信息
 * 1.base_user中基础信息{@link demo.tcyeee.entity.po.BaseUser}
 * 2.全局接口,获取当前登录信息也返回此实体类 {@link demo.tcyeee.utils.BaseUtils}中{@see userInfo()}方法
 *
 * @author tcyeee
 * @since 2019-05-05 16:39
 */
@Data
public class BaseInfoVo {

    /* 用户信息 */
    private Integer userId;           // id
    private Integer enable;           // 是否可用
    private String username;          // username
    private String password;          // [验证用]密码
    private Integer mobilephone;      // 手机号
}
