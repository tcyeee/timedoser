package com.timedoser.cloud.main.controller.manege;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.server.IUserServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/17 15:47
 */
@RestController
@RequestMapping("manage/user")
public class UserController {

    @Resource
    private IUserServer userServer;


    /**
     * 查看所有的用户
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @PostMapping("getAll")
    public Result getAll(@RequestBody StatusDto param) {
        return Result.page(userServer.getAll(param));
    }

    /**
     * 查看一个用户
     *
     * @param id 用户ID
     * @return status
     */
    @GetMapping("getOne")
    public Result getOne(Integer id) {
        return Result.ok(userServer.getOne(id));
    }

    /**
     * 修改用户信息
     *
     * @param params 用户信息
     * @return status
     */
    @PostMapping("updateOne")
    public Result updateOne(@RequestBody BaseUser params) {
        return Result.ok(userServer.updateOne(params));
    }

    /**
     * 添加用户
     *
     * @param params 用户信息
     * @return status
     */
    @PostMapping("addOne")
    public Result addOne(@RequestBody BaseUser params) {
        return Result.ok(userServer.addOne(params));
    }

}
