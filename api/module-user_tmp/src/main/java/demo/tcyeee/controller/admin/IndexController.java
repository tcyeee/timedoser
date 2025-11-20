package demo.tcyeee.controller.admin;

import demo.tcyeee.service.AdminIndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;

/**
 * @author tcyeee
 * @date 2020/1/7 16:52
 */
@RestController
@RequestMapping("adminIndex")
public class IndexController {

    @Resource
    private AdminIndexService adminIndexService;


    /**
     * 获取首页统计数据
     *
     * @return index count
     */
    @GetMapping("getCount")
    public String getCount() {
        return creatJsonResponse(adminIndexService.getCount());
    }
}
