package com.timedoser.cloud.main.controller.manege;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.main.server.IRoleServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/22 15:59
 */
@RestController
@RequestMapping("manage/role")
public class RoleController {

    @Resource
    private IRoleServer roleServer;


    /**
     * 查看所有的角色
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @PostMapping("getAll")
    public Result getAll(@RequestBody StatusDto param) {
        return Result.ok(roleServer.getAll(param));
    }

    /**
     * 查看一个角色
     *
     * @param id 角色ID
     * @return status
     */
    @GetMapping("getOne")
    public Result getOne(Integer id) {
        return Result.ok(roleServer.getOne(id));
    }

    /**
     * 修改角色信息
     *
     * @param params 角色信息
     * @return status
     */
    @PostMapping("updateOne")
    public Result updateOne(@RequestBody AclRole params) {
        return Result.ok(roleServer.updateOne(params));
    }

    /**
     * 添加角色
     *
     * @param params 角色信息
     * @return status
     */
    @PostMapping("addOne")
    public Result addOne(@RequestBody AclRole params) {
        return Result.ok(roleServer.addOne(params));
    }

}
