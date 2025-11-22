package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:02
 */
@Service
public interface IRoleServer {

    /**
     * 查看所有的角色
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    List<AclRole> getAll(StatusDto param);

    /**
     * 查看一个角色
     *
     * @param id 角色ID
     * @return status
     */
    AclRole getOne(Integer id);

    /**
     * 修改角色信息
     *
     * @param params 角色信息
     * @return status
     */
    StatusDto updateOne(AclRole params);

    /**
     * 添加角色
     *
     * @param params 角色信息
     * @return status
     */
    StatusDto addOne(AclRole params);
}
