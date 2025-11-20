package demo.tcyeee.entity.vo;

import demo.tcyeee.entity.po.PlanTask;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查看所有的任务
 *
 * @author tcyeee
 * @date 2019-08-22 10:28
 */
@Data
public class PlantaskList implements Serializable {
    private static final long serialVersionUID = 5609619920347786179L;

    private List<PlanTask> waitTask;      // 待办任务
    private int waitTaskCount;            // count

    private List<PlanTask> finishTask;    // 已完成任务
    private int finishTaskCount;          // count

}
