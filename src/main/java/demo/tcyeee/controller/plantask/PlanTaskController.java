package demo.tcyeee.controller.planTask;

import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.service.PlanTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.entity.base.ReturnInfo.ReturnCode.*;
import static demo.tcyeee.utils.ResponseUtils.creatErrResponse;
import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;


/**
 * 任务计划(待办)
 *
 * @author chenyueee
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
    public String addOne(PlanTask planTask) {
//        if (task == null || StringUtils.isBlank(task.getName())) {
//            return creatErrResponse(PARAMS_ERROR);
//        }

//        boolean creatTask = planTaskService.creatTask(task);
//        return creatTask ? creatJsonResponse(SUCCESS) : creatErrResponse(SYSTEM_ERROR);
        return null;
    }


    /**
     * 获取当前用户所有的任务
     *
     * @return data
     */
    @RequestMapping("getAllTask")
    public String getAllTask() {
        return creatJsonResponse(planTaskService.findAllByUser());
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

    /**
     * 删除任务
     *
     * @param taskId 任务id
     * @return status
     */
    @RequestMapping("deleteTask")
    public String deleteTask(Integer taskId) {
        if (taskId == null) return creatErrResponse(PARAMS_ERROR);

        planTaskService.delete(taskId);
        return creatJsonResponse(SUCCESS);
    }
}
