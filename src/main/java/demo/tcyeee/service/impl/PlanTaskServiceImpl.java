package demo.tcyeee.service.impl;

import demo.tcyeee.dao.PlanTaskDao;
import demo.tcyeee.dao.PlanTaskHistoryDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.po.PlanTaskHistory;
import demo.tcyeee.entity.vo.PlantaskList;
import demo.tcyeee.entity.vo.addPlanTaskVo;
import demo.tcyeee.mapper.PlanTaskMapper;
import demo.tcyeee.service.PlanTaskService;
import demo.tcyeee.utils.BaseUtils;
import demo.tcyeee.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tcyeee
 * @since 2019-07-20 16:36
 */
@Service
public class PlanTaskServiceImpl implements PlanTaskService {

    @Resource
    private PlanTaskDao planTaskDao;

    @Resource
    private PlanTaskMapper planTaskMapper;

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private PlanTaskHistoryDao historyDao;

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

        PlanTask task = new PlanTask();
        task.setName(vo.getName());
        task.setBaseUser(baseInfoVo);
        task.setType(PlanTask.typeEnum.defult);
        task.setTomatoRistTime(5);
        task.setTomatoWorkTime(Integer.valueOf(vo.getMinute()));
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
    public PlantaskList findAllByUser() {
        BaseUser baseUser = tokenUtils.getUserInfo();
        PlantaskList result = planTaskMapper.getTaskCount(baseUser.getId());

        List<PlanTask> waitTask = planTaskDao.findAllByBaseUserAndTypeOrderBySumTimeDesc(baseUser, PlanTask.typeEnum.defult);
        List<PlanTask> clenTask = planTaskDao.findAllByBaseUserAndTypeOrderBySumTimeDesc(baseUser, PlanTask.typeEnum.clean);

        result.setWaitTask(waitTask);
        result.setFinishTask(clenTask);
        return result;
    }


    /**
     * 修改任务信息
     *
     * @param task 任务信息
     * @return status
     */
    @Override
    public boolean update(PlanTask task) {
        PlanTask save = planTaskDao.getOne(task.getId());
        save.setBaseUser(tokenUtils.getUserInfo());
        save.setIcon(StringUtils.isNotBlank(task.getIcon()) ? task.getIcon() : save.getIcon());
        save.setName(StringUtils.isNotBlank(task.getName()) ? task.getName() : save.getName());
        save.setTomatoWorkTime(task.getTomatoWorkTime() != null ? task.getTomatoWorkTime() : save.getTomatoWorkTime());

        return planTaskDao.save(save) != null;
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
        BaseUser baseUser = BaseUtils.userInfo();
        PlanTask planTask = planTaskDao.getOne(Integer.parseInt(taskId));

        // 1.添加一条任务历史
        PlanTaskHistory history = new PlanTaskHistory();
        history.setBaseUser(baseUser);
        history.setPlanTask(planTask);
        history.setTomatoWorkTime(planTask.getTomatoWorkTime());
        historyDao.save(history);

        PlanTask task = planTaskDao.getOne(Integer.valueOf(taskId));
        task.setType(PlanTask.typeEnum.clean);
        return planTaskDao.save(task) != null;
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
