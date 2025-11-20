package demo.tcyeee.controller.plantask;

import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.vo.addPlanTaskVo;
import demo.tcyeee.service.PlanTaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.*;


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
            return creatErrResponse(PARAMS_ERROR_INFO);
        }

        boolean creatTask = planTaskService.creatTask(vo);
        return creatTask ? creatSuccessResponse() : creatErrResponse();
    }


    /**
     * 删除一个任务
     *
     * @return status
     */
    @RequestMapping("deleteOne")
    public String deleteOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR_INFO);
        return planTaskService.deleteOne(taskId) ? creatSuccessResponse() : creatErrResponse();
    }


    /**
     * 完成一个任务
     *
     * @return status
     */
    @RequestMapping("finishOne")
    public String finishOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR_INFO);
        return planTaskService.finishOne(taskId) ? creatSuccessResponse() : creatErrResponse();
    }

    /**
     * 重新开始一个任务
     *
     * @return status
     */
    @RequestMapping("restartOne")
    public String restartOne(String taskId) {
        if (StringUtils.isBlank(taskId)) return creatErrResponse(PARAMS_ERROR_INFO);
        return planTaskService.restartOne(taskId) ? creatSuccessResponse() : creatErrResponse();
    }

    /**
     * 获取当前用户所有的任务
     *
     * @return data
     * @since version_1.1.01
     */
    @GetMapping("getAll")
    public String getAll() {
        return creatJsonResponse(planTaskService.findAllByUser());
    }


    /**
     * 修改任务信息
     *
     * @param task 修改的任务信息
     * @return status
     */
    @PostMapping("updateTask")
    public String updateTask(PlanTask task) {
        if (task == null || task.getId() == null) {
            return creatErrResponse(PARAMS_ERROR_INFO);
        }

        boolean update = planTaskService.update(task);
        return update ? creatSuccessResponse() : creatErrResponse();
    }
}
