package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户留言
 *
 * @author tcyeee@outlook.com
 * @date 2019-07-22 10:28
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "suggest_message")
public class SuggestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    @Column(nullable = false)
    private String context;

    // 创建时间
    @Column(columnDefinition = "timestamp DEFAULT current_timestamp")
    private Date createdate;

    // 用户留言类型
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private messageTypeEnum messageType;

    @Getter
    @AllArgsConstructor
    public enum messageTypeEnum {
        err(0, "错误"),
        defule(1, "普通留言"),
        tag(2, "星标留言");

        private int index;
        private String remark;
    }
}
