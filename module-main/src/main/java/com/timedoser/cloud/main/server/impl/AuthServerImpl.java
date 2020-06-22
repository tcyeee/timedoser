package com.timedoser.cloud.main.server.impl;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclAuth;
import com.timedoser.cloud.main.server.IAuthServer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:12
 */
@Service
public class AuthServerImpl implements IAuthServer {
    /**
     * 查看所有的权限
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @Override
    public List<AclAuth> getAll(StatusDto param) {
        return null;
    }

    /**
     * 查看一个权限
     *
     * @param id 权限ID
     * @return status
     */
    @Override
    public AclAuth getOne(Integer id) {
        return null;
    }

    /**
     * 修改权限信息
     *
     * @param params 权限信息
     * @return status
     */
    @Override
    public StatusDto updateOne(AclAuth params) {
        return null;
    }

    /**
     * 添加权限
     *
     * @param params 权限信息
     * @return status
     */
    @Override
    public StatusDto addOne(AclAuth params) {
        return null;
    }
}
