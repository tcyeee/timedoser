package demo.tcyeee.controller.version;

import demo.tcyeee.service.VersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;

/**
 * 版本控制
 *
 * @author tcyeee
 * @since 2019-07-21 10:32
 */
@RestController
@RequestMapping("version")
public class VersionController {

    @Resource
    private VersionService versionService;

    @Value("${version}")
    private String verison;

    /**
     * 查看当前版本
     *
     * @return version
     */
    @RequestMapping("queryVersion")
    public String queryVersion() {
        return creatJsonResponse(verison);
    }


    /**
     * 查看版本更新内容(添加缓存,以版本号判断)
     *
     * @return data
     */
    @RequestMapping("queryVersionUpdate")
    public String queryVersionUpdate() {
        return creatJsonResponse(versionService.queryVersionUpdate(verison));
    }
}
