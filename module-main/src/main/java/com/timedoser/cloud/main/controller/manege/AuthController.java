package com.timedoser.cloud.main.controller.manege;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclAuth;
import com.timedoser.cloud.main.server.IAuthServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/22 16:08
 */
@RestController
@RequestMapping("manage/auth")
public class AuthController {

    @Resource
    private IAuthServer authServer;


    /**
     * 查看所有的权限
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @PostMapping("getAll")
    public Result getAll(@RequestBody StatusDto param) {
        return Result.ok(authServer.getAll(param));
    }

    /**
     * 查看一个权限
     *
     * @param id 权限ID
     * @return status
     */
    @GetMapping("getOne")
    public Result getOne(Integer id) {
        return Result.ok(authServer.getOne(id));
    }

    /**
     * 修改权限信息
     *
     * @param params 权限信息
     * @return status
     */
    @PostMapping("updateOne")
    public Result updateOne(@RequestBody AclAuth params) {
        return Result.ok(authServer.updateOne(params));
    }

    /**
     * 添加权限
     *
     * @param params 权限信息
     * @return status
     */
    @PostMapping("addOne")
    public Result addOne(@RequestBody AclAuth params) {
        return Result.ok(authServer.addOne(params));
    }

}
