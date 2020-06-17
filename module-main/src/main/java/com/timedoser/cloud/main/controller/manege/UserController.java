package com.timedoser.cloud.main.controller.manege;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.main.server.UserServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/17 15:47
 */
@RestController
@RequestMapping("controller/user")
public class UserController {

    @Resource
    private UserServer userServer;

    /**
     * 分页查看所有信息
     *
     * @param param 状态
     * @return data
     */
    @PostMapping("findAll")
    public Result findAll(@RequestBody StatusDto param) {
        return Result.ok(userServer.findAll(param));
    }
}
