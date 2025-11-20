package demo.tcyeee.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenyueee
 * @since 2020/2/24 15:58
 */
@Data
@Entity
@Table(name = "tomato_history")
public class TomatoHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 任务过程中是否分心(0:没有 1:有)
    @Column(name = "has_divert")
    private Integer hasDivert;

    // 任务花费的时间
    @Column(name = "tomato_time")
    private Integer tomatoTime;

    // 任务类型 0:工作 1:休息
    @Column(name = "type")
    private Integer type;

    // 创建人账号
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 关联项目
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
}
