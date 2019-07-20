package demo.tcyeee.service.impl;

import demo.tcyeee.dao.PlanTaskDao;
import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.BaseInfoVo;
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

    /**
     * 新增一个待办任务
     *
     * @param task 任务信息
     * @return status
     */
    @Override
    public boolean creatTask(PlanTask task) {
        BaseInfoVo baseInfoVo = TokenUtils.userInfo();
        if (baseInfoVo == null) {
            return false;
        }

        // 新加数据
        task.setUserId(baseInfoVo.getUserId());
        planTaskDao.save(task);
        return true;
    }


    /**
     * 获取用户创建的所有任务
     *
     * @return task list
     */
    @Override
    public List<PlanTask> findAllByUser() {
        BaseInfoVo baseInfoVo = TokenUtils.userInfo();
        if (baseInfoVo == null) {
            return null;
        }
        return planTaskDao.findAllByUserId(baseInfoVo.getUserId());
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
    public boolean delete(Integer taskId) {
        PlanTask task = new PlanTask();
        task.setId(taskId);

        planTaskDao.delete(task);
        return true;
    }
}
