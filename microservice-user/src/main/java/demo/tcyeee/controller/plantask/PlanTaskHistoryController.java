package demo.tcyeee.controller.plantask;

import demo.tcyeee.service.PlanTaskHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.PARAMS_ERROR_INFO;
import static demo.tcyeee.utils.ResponseUtils.creatErrResponse;

/**
 * 任务历史记录
 *
 * @author chenyueee
 * @since 2019-09-01 21:25
 */
@RestController
@RequestMapping("planTaskHistory")
public class PlanTaskHistoryController {


    @Resource
    private PlanTaskHistoryService planTaskHistoryService;

    /**
     * 完成一条任务
     *
     * @return data
     */
    @RequestMapping("addOne")
    public String addOne(Integer planTaskId) {
        if (planTaskId == null) return creatErrResponse(PARAMS_ERROR_INFO);

        return planTaskHistoryService.addOne(planTaskId);
    }

    /**
     * 查看所有
     *
     * @return data
     */
    @RequestMapping("findAll")
    public String findAll() {
        return planTaskHistoryService.findAll();
    }


    /**
     * 删除一条
     *
     * @return data
     */
    @RequestMapping("deleteOne")
    public String deleteOne(Integer planTaskId) {
        return planTaskHistoryService.deleteOne(planTaskId);
    }

}
