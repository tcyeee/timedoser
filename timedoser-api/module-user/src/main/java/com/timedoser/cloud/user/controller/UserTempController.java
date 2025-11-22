package com.timedoser.cloud.user.controller;

import cn.hutool.system.SystemUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tcyeee
 * @date 2020/6/20 3:14 下午
 */
@Log4j2
@RestController
@RequestMapping("userTemp")
public class UserTempController {

    @GetMapping("linkTest")
    private void linkTest() {
        log.error("⚠️⚠️⚠️ \n" + SystemUtil.getHostInfo().toString());
    }
}
