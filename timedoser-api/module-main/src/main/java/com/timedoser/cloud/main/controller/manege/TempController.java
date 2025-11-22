package com.timedoser.cloud.main.controller.manege;

import cn.hutool.system.SystemUtil;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.main.server.feign.TempFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @date 2020/6/20 3:03 下午
 */
@Log4j2
@RestController
@RequestMapping("temp")
public class TempController {

    @Resource
    private TempFeign tempFeign;

    @GetMapping("linkTest")
    private Result linkTest() {
        log.error("⚠️⚠️⚠️ \n" + SystemUtil.getHostInfo());
        tempFeign.linkTest();
        return Result.ok();
    }

}
