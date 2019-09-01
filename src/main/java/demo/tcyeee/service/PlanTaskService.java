package demo.tcyeee.service;

import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.PlantaskList_12;
import demo.tcyeee.entity.vo.addPlanTaskVo;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-07-20 16:35
 */
@Service
public interface PlanTaskService {

    /**
     * 新增一个待办任务
     *
     * @param vo 任务信息
     * @return status
     */
    boolean creatTask(addPlanTaskVo vo);

    /**
     * 获取当前用户所有的任务
     *
     * @return data
     * @since version_1.1.01
     */
    PlantaskList_12 findAllByUser_12();


    /**
     * 修改任务信息
     *
     * @param task 任务信息
     * @return status
     */
    boolean update(PlanTask task);

    /**
     * 删除任务信息
     *
     * @param taskId 任务id
     * @return status
     */
    boolean deleteOne(String taskId);

    /**
     * 完成一个任务
     *
     * @return status
     */
    boolean finishOne(String taskId);

    /**
     * 重新开始一个任务
     *
     * @return status
     */
    boolean restartOne(String taskId);
}
