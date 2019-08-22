package demo.tcyeee.entity.vo;

import demo.tcyeee.controller.planTask.PlanTaskController;
import demo.tcyeee.entity.po.PlanTask;
import lombok.Data;

import java.util.List;

/**
 * 查看所有的任务
 *
 * @author chenyueee
 * @date 2019-08-22 10:28
 * @see PlanTaskController#getAllTask_12()
 */
@Data
public class PlantaskList_12 {

    private List<PlanTask> waitTask;      // 待办任务
    private int waitTaskCount;            // count

    private List<PlanTask> finishTask;    // 已完成任务
    private int finishTaskCount;          // count

}
