package demo.tcyeee.entity.vo;

import demo.tcyeee.entity.po.BaseUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author huxiong
 * @date 2019-07-22 14:28
 */
@Getter
@Setter
public class SuggestMessageVo{

    private String messageId;   // 留言id
    private String context;
    private Date createdate;

    private String userId;      // 用户id
    private String username;    // 昵称
    private String avatarUrl;   // 头像地址
    /** #{@link BaseUser.accountTypeEnum} 用户类型 */
    private Integer accountType;


    public SuggestMessageVo(String messageId, String context, Date createdate, String userId, String username, String avatarUrl, Integer accountType) {
        this.messageId = messageId;
        this.context = context;
        this.createdate = createdate;
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.accountType = accountType;
    }

    public SuggestMessageVo() {
    }
}
