package demo.tcyeee.entity.vo;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.SuggestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huxiong
 * @date 2019-07-22 14:28
 */
@Getter
@Setter
public class SuggestMessageVo extends SuggestMessage {
    private String avatarUrl;   // 头像地址
    private String username;    // 昵称

    /** #{@link BaseUser.accountTypeEnum} 用户类型 */
    private Integer accountType;

    public SuggestMessageVo(String avatarUrl, String username, Integer accountType) {

        this.avatarUrl = avatarUrl;
        this.username = username;
        this.accountType = accountType;
    }
}
