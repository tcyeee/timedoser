package demo.tcyeee.controller.planTask;

import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.addPlanTaskVo;
import demo.tcyeee.service.PlanTaskService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.entity.base.ReturnInfo.ReturnCode.*;
import static demo.tcyeee.utils.ResponseUtils.creatErrResponse;
import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;


/**
 * 任务计划(待办)
 *
 * @author tcyeee
 * @date 2019-07-20 16:21
 */
@RestController
@RequestMapping("planTask")
public class PlanTaskController {

    @Resource
    private PlanTaskService planTaskService;

    /**
     * 创建任务
     *
     * @return status
     */
    @RequestMapping("addOne")
    public String addOne(addPlanTaskVo vo) {
        if (StringUtils.isBlank(vo.getMinute()) || StringUtils.isBlank(vo.getName())) {
            return creatErrResponse(PARAMS_ERROR);
        }

        boolean creatTask = planTaskService.creatTask(vo);
        return creatTask ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
    }


    /**
     * 删除一个任务
     *
     * @return status
     */
    @RequestMapping("deleteOne")
    public String deleteOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR);
        return planTaskService.deleteOne(taskId) ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
    }


    /**
     * 完成一个任务
     *
     * @return status
     */
    @RequestMapping("finishOne")
    public String finishOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR);
        return planTaskService.finishOne(taskId) ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
    }

    /**
     * 重新开始一个任务
     *
     * @return status
     */
    @RequestMapping("restartOne")
    public String restartOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR);
        return planTaskService.restartOne(taskId) ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
    }

    /**
     * 获取当前用户所有的任务
     *
     * @return data
     * @since version_1.1.01
     */
    @RequestMapping("getAllTask_12")
    public String getAllTask_12() {
        return creatJsonResponse(planTaskService.findAllByUser_12());
    }


    /**
     * 修改任务信息
     *
     * @param task 修改的任务信息
     * @return status
     */
    @RequestMapping("updateTask")
    public String updateTask(PlanTask task) {
        if (task == null || task.getId() == null) {
            return creatErrResponse(PARAMS_ERROR);
        }

        boolean update = planTaskService.update(task);
        return update ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
    }
}
