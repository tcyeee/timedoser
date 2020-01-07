package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import static demo.tcyeee.utils.ResponseUtils.PARAMS_ERROR_INFO;


/**
 * 任务列表
 *
 * @author tcyeee@outlook.com
 * @date 2019-07-20 16:00:32
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "plan_task")
public class PlanTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 32, updatable = false)
    private Integer id;

    // 用户id
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    // 任务名称
    @NotEmpty(message = PARAMS_ERROR_INFO + "name")
    @Column(nullable = false, length = 120)
    private String name;

    // 备注
    private String remark;

    // 创建时间
    @Column(columnDefinition = "timestamp DEFAULT current_timestamp")
    private Date createdate;

    // 是否可用
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private typeEnum type;

    // 番茄时长(工作时长)
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 25")
    private Integer tomatoWorkTime;

    // 番茄时长(休息时长)
    @Column(nullable = false, columnDefinition = "int(4) DEFAULT 5")
    private Integer tomatoRistTime;

    @Getter
    @AllArgsConstructor
    public enum typeEnum {
        err(0, "弃用位置"),
        defult(1, "未完成"),
        clean(2, "已完成"),
        delele(3, "已经删除");

        private int index;
        private String remark;
    }

    public PlanTask() {
    }

    public PlanTask(BaseUser baseUser, @NotEmpty(message = PARAMS_ERROR_INFO + "name") String name, String remark, Date createdate, typeEnum type, Integer tomatoWorkTime, Integer tomatoRistTime) {
        this.baseUser = baseUser;
        this.name = name;
        this.remark = remark;
        this.createdate = createdate;
        this.type = type;
        this.tomatoWorkTime = tomatoWorkTime;
        this.tomatoRistTime = tomatoRistTime;
    }

    public PlanTask(int id) {
        this.id = id;
    }
}
