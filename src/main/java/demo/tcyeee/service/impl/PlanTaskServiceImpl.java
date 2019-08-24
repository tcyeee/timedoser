package demo.tcyeee.service.impl;

import demo.tcyeee.dao.PlanTaskDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.PlantaskList_12;
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
                .name(vo.getName())
                .baseUser(baseInfoVo)
                .type(PlanTask.typeEnum.defult)
                .tomatoRistTime(5)
                .tomatoWorkTime(Integer.valueOf(vo.getMinute()))
                .build();
        return planTaskDao.save(task) != null;
    }

    /**
     * 获取当前用户所有的任务
     * 1.已完成任务只查询10条
     * 2.数据库无任何数据则添加一条示例任务
     *
     * @return data
     * @since version_1.1.01
     */
    @Override
    public PlantaskList_12 findAllByUser_12() {
        PlantaskList_12 result = new PlantaskList_12();
        BaseUser baseUser = tokenUtils.getUserInfo();
        int finishTaskCount = planTaskDao.countByBaseUserAndType(baseUser, PlanTask.typeEnum.clean);
        int waitTaskCount = planTaskDao.countByBaseUserAndType(baseUser, PlanTask.typeEnum.defult);

        // 如果是第一次查询则创建一条任务
        if (planTaskDao.countByBaseUser(baseUser) == 0) {
            this.creatDemoTask(baseUser);
        }

        List<PlanTask> waitTask = planTaskDao.findAllByBaseUserAndTypeOrderByCreatedateDesc(baseUser, PlanTask.typeEnum.defult);
        List<PlanTask> clenTask = planTaskDao.findAllByBaseUserAndTypeOrderByCreatedateDesc(baseUser, PlanTask.typeEnum.clean);

        result.setWaitTask(waitTask);
        result.setFinishTask(clenTask);
        result.setWaitTaskCount(waitTaskCount);
        result.setFinishTaskCount(finishTaskCount);

        return result;
    }

    // 创建一个示例项目
    private void creatDemoTask(BaseUser baseUser) {
        PlanTask planTask = PlanTask.builder()
                .baseUser(baseUser)
                .tomatoWorkTime(25)
                .tomatoRistTime(5)
                .name("示例任务")
                .type(PlanTask.typeEnum.defult)
                .build();
        planTaskDao.save(planTask);
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
        return planTaskDao.diyUpdataTask(taskId, PlanTask.typeEnum.delele.getIndex()) >= 1;
    }


    /**
     * 完成一个任务
     *
     * @return status
     */
    @Override
    public boolean finishOne(String taskId) {
        return planTaskDao.diyUpdataTask(taskId, PlanTask.typeEnum.clean.getIndex()) >= 1;
    }


    /**
     * 重新开始一个任务
     *
     * @return status
     */
    @Override
    public boolean restartOne(String taskId) {
        return planTaskDao.diyUpdataTask(taskId, PlanTask.typeEnum.defult.getIndex()) >= 1;
    }
}
