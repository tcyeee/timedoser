package demo.tcyeee.entity.vo;

import demo.tcyeee.entity.po.BaseUser;
import lombok.Data;

import java.util.Date;

/**
 * @author huxiong
 * @date 2019-07-22 14:28
 */
@Data
public class SuggestMessageVo {

    private String messageId;   // 留言id
    private String context;
    private Date createdate;

    private String userId;      // 用户id
    private String username;    // 昵称
    private String avatarUrl;   // 头像地址

    /**
     * #{@link BaseUser.accountTypeEnum} 用户类型
     */
    private Integer accountType;

}
