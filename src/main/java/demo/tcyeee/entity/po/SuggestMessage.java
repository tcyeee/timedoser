package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tcyeee@outlook.com
 * @date 2019-07-22 10:28
 */
@Data
@Entity
@Builder
@Table(name = "suggest_message")
public class SuggestMessage {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    @Column(nullable = false)
    private String context;

    /** 创建时间 */
    @Column(columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    /** #{@link messageTypeEnum} 留言类型 */
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private Integer messageType;

    /** 用户留言类型 */
    @Getter
    @AllArgsConstructor
    public enum messageTypeEnum {
        one(1, "普通留言"),
        two(2, "星标留言");

        private int type;
        private String remark;
    }

    @Tolerate
    public SuggestMessage() {}

}
