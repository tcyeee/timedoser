package com.timedoser.cloud.main.server.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.FlxedData;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclAuth;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.mapper.AclAuthMapper;
import com.timedoser.cloud.main.mapper.AclRoleMapper;
import com.timedoser.cloud.main.server.IAuthServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:12
 */
@Service
public class AuthServerImpl implements IAuthServer {
    @Resource
    private AclAuthMapper authMapper;

    /**
     * 查看所有的权限
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @Override
    public List<AclAuth> getAll(StatusDto param) {
        Page<BaseUser> page = new Page<>(param.getCurrentPage(), param.getPageSize());
        return authMapper.getAll(page, param.getStatus());
    }

    /**
     * 查看一个权限
     *
     * @param id 权限ID
     * @return status
     */
    @Override
    public AclAuth getOne(Integer id) {
        return authMapper.selectById(id);
    }

    /**
     * 修改权限信息
     *
     * @param params 权限信息
     * @return status
     */
    @Override
    public StatusDto updateOne(AclAuth params) {
        boolean status = authMapper.updateById(params) > 0;
        return new StatusDto(status, FlxedData.authUpdate(status));
    }

    /**
     * 添加权限
     *
     * @param params 权限信息
     * @return status
     */
    @Override
    public StatusDto addOne(AclAuth params) {
        boolean status = authMapper.insert(params) > 0;
        return new StatusDto(status, FlxedData.authUpdate(status));
    }
}
