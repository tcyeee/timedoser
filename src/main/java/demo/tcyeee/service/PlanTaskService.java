package demo.tcyeee.service;

import demo.tcyeee.entity.po.PlanTask;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyueee
 * @since 2019-07-20 16:35
 */
@Service
public interface PlanTaskService {

    /**
     * 新增一个待办任务
     *
     * @param task 任务信息
     * @return status
     */
    boolean creatTask(PlanTask task);

    /**
     * 获取用户创建的所有任务
     *
     * @return task list
     */
    List<PlanTask> findAllByUser();


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
    boolean delete(Integer taskId);
}
