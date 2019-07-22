package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "id", unique = true, nullable = false, length = 200, updatable = false)
    private String id;

    @Column(name = "user_id", nullable = false, length = 200)
    private String userId;

    @Column(name = "context", nullable = false)
    private String context;

    /** 创建时间 */
    @Column(name = "createdate", columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    /** #{@link messageTypeEnum} 留言类型 */
    @Column(name = "message_type", nullable = false, columnDefinition = "int(4) DEFAULT 1")
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
