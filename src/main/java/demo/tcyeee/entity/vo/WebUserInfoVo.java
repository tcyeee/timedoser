package demo.tcyeee.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author chenyueee
 * @since 2019/12/1 18:19
 */
@Data
public class WebUserInfoVo {
    private String id;
    private String username;            // 昵称
    private String mobilephone;
    private String avatarUrl;           // 头像地址
    private Integer gender;             // 性别

    private List<Integer> roles;         // 角色
    private String token;

}
