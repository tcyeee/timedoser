package demo.tcyeee.service.impl;

import demo.tcyeee.dao.PlanTaskDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.addPlanTaskVo;
import demo.tcyeee.service.PlanTaskService;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyueee
 * @since 2019-07-20 16:36
 */
@Service
public class PlanTaskServiceImpl implements PlanTaskService {

    @Resource
    private PlanTaskDao planTaskDao;

    @Resource
    private TokenUtils tokenUtils;

    /**
     * 新增一个待办任务
     *
     * @param vo 任务信息
     * @return status
     */
    @Override
    public boolean creatTask(addPlanTaskVo vo) {
        BaseUser baseInfoVo = tokenUtils.getUserInfo();
        if (baseInfoVo == null) return false;

        PlanTask task = PlanTask.builder()
                .type(1)
                .name(vo.getName())
                .userId(baseInfoVo.getUserId())
                .tomatoWorkTime(Integer.valueOf(vo.getMinute()))
                .build();
        return planTaskDao.save(task) != null;
    }


    /**
     * 获取用户创建的所有任务
     *
     * @return task list
     */
    @Override
    public List<PlanTask> findAllByUser() {
        BaseUser baseUser = tokenUtils.getUserInfo();
        if (baseUser == null) return null;

        // 如果是第一次查询则创建一条任务
        if (planTaskDao.countByUserId(baseUser.getUserId()) == 0) {
            PlanTask planTask = PlanTask.builder()
                    .userId(baseUser.getUserId())
                    .tomatoWorkTime(25)
                    .tomatoRistTime(5)
                    .name("示例任务")
                    .type(1)
                    .build();
            planTaskDao.save(planTask);
        }

        // 如果没有任务的话就去创建一个示例项目
        return planTaskDao.findAllByUserIdAndTypeIsNotOrderByCreatedateAsc(baseUser.getUserId(), 9);
    }


    /**
     * 修改任务信息
     *
     * @param task 任务信息
     * @return status
     */
    @Override
    public boolean update(PlanTask task) {
        PlanTask update = planTaskDao.save(task);
        return task.getId().equals(update.getId());
    }


    /**
     * 删除任务信息
     *
     * @param taskId 任务id
     * @return status
     */
    @Override
    public boolean deleteOne(String taskId) {
        return planTaskDao.diyDeleteOne(taskId) >= 1;
    }
}
