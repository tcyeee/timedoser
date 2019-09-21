package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 任务历史
 *
 * @author tcyeee
 * @since 2019-08-22 23:31
 */
@Data
@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@Table(name = "plan_task_history")
public class PlanTaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlanTask planTask;

    private int tomatoWorkTime;          // 学习时长(因为关联的任务是可以被修改的,所以这里直接记录下学习的时长)
    private Date creatTime;              // 创建时间

    @Column(nullable = false)
    private recordStatus status;         // 数据状态


    @Getter
    @AllArgsConstructor
    public enum recordStatus {

        err(0, "错误"),
        defule(1, "默认状态"),
        delete(2, "已经删除");

        private int index;
        private String remark;
    }


    @Tolerate
    public PlanTaskHistory() {
    }

}
