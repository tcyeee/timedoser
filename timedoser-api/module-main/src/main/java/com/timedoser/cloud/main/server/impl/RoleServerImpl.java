package com.timedoser.cloud.main.server.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.FlxedData;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.mapper.AclRoleMapper;
import com.timedoser.cloud.main.server.IRoleServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:07
 */
@Service
public class RoleServerImpl implements IRoleServer {
    @Resource
    private AclRoleMapper roleMapper;

    /**
     * 查看所有的角色
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @Override
    public List<AclRole> getAll(StatusDto param) {
        Page<BaseUser> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        return roleMapper.getAll(page, param.getStatus());
    }

    /**
     * 查看一个角色
     *
     * @param id 角色ID
     * @return status
     */
    @Override
    public AclRole getOne(Integer id) {
        return roleMapper.selectById(id);
    }

    /**
     * 修改角色信息
     *
     * @param params 角色信息
     * @return status
     */
    @Override
    public StatusDto updateOne(AclRole params) {
        boolean status = roleMapper.updateById(params) > 0;
        return new StatusDto(status, FlxedData.roleUpdate(status));
    }

    /**
     * 添加角色
     *
     * @param params 角色信息
     * @return status
     */
    @Override
    public StatusDto addOne(AclRole params) {
        boolean status = roleMapper.insert(params) > 0;
        return new StatusDto(status, FlxedData.roleUpdate(status));
    }
}
