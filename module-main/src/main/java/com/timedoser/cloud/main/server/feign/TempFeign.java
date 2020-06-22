package com.timedoser.cloud.main.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tcyeee
 * @date 2020/6/20 3:18 下午
 */
@FeignClient(name = "module-user")
public interface TempFeign {

    @GetMapping(value = "/userTemp/linkTest")
    void linkTest();
}
