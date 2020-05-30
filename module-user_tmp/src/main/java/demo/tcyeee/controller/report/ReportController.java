package demo.tcyeee.controller.report;

import demo.tcyeee.entity.base.FixedInfo;
import demo.tcyeee.service.ReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;

/**
 * 报表类
 *
 * @author chenyueee
 * @since 2019-09-22 20:15
 */
@RestController
@RequestMapping("report")
public class ReportController {

    @Resource
    private ReportService reportService;

    /**
     * 页面初始化需要的数据
     *
     * @return page data
     */
    @RequestMapping("pageData")
    public String pageData() {
        return creatJsonResponse(reportService.pageData());
    }

    @RequestMapping("test")
    public String test() {
        return creatJsonResponse(FixedInfo.LINK_TEST);
    }
}
