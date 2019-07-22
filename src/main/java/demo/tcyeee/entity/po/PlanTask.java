package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import static demo.tcyeee.entity.enums.base.ReturnCodeList.PARAMS_ERROR_INFO;

/**
 * 任务列表
 *
 * @author tcyeee@outlook.com
 * @date 2019-07-20 16:00:32
 */
@Data
@Entity
@Builder
@Table(name = "plan_task")
public class PlanTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32, updatable = false)
    private Integer id;

    /** 用户id {@link BaseUser} */
    @Column(name = "user_id", nullable = false, length = 50, updatable = false)
    private String userId;

    // 任务名称
    @NotEmpty(message = PARAMS_ERROR_INFO + "name")
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    // 备注
    @Column(name = "remark")
    private String remark;

    // 创建时间
    @Column(name = "createdate", columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    /** 是否可用 默认为1 {@link enableTypeEnum} */
    @Column(name = "enable", nullable = false, columnDefinition = "int(4) DEFAULT 1")
    private Integer enable;

    @Getter
    @AllArgsConstructor
    public enum enableTypeEnum {
        defult(1, "正常使用"),
        two(2, "已经删除");

        private int type;
        private String remark;
    }

    @Tolerate
    PlanTask() {}
}
