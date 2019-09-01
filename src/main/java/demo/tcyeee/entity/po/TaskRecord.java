package demo.tcyeee.entity.po;

import lombok.Builder;
import lombok.Data;
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
@Table(name = "task_record")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlanTask planTask;

    private Date creatTime;              // 创建时间
    private int tomatoWorkTime;          // 学习时长






    @Tolerate
    public TaskRecord() {
    }

}
