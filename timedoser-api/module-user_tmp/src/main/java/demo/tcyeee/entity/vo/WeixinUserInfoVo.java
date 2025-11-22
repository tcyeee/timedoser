package demo.tcyeee.entity.vo;

import lombok.Data;

/**
 * 微信获取的基础用户信息
 *
 * @author tcyeee
 * @since 2019-07-25 23:41
 */
@Data
public class WeixinUserInfoVo {

    private String nickName;   // 昵称
    private String avatarUrl;  // 头像
    private Integer gender;    // 性别

    private String country;    // 国家
    private String province;   // 省
    private String city;       // 市
}
