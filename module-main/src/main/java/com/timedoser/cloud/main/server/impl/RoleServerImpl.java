package com.timedoser.cloud.main.server.impl;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.main.server.IRoleServer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:07
 */
@Service
public class RoleServerImpl implements IRoleServer {
    /**
     * 查看所有的角色
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @Override
    public List<AclRole> getAll(StatusDto param) {
        return null;
    }

    /**
     * 查看一个角色
     *
     * @param id 角色ID
     * @return status
     */
    @Override
    public AclRole getOne(Integer id) {
        return null;
    }

    /**
     * 修改角色信息
     *
     * @param params 角色信息
     * @return status
     */
    @Override
    public StatusDto updateOne(AclRole params) {
        return null;
    }

    /**
     * 添加角色
     *
     * @param params 角色信息
     * @return status
     */
    @Override
    public StatusDto addOne(AclRole params) {
        return null;
    }
}
