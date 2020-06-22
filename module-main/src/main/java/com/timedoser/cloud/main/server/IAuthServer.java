package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclAuth;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:10
 */
@Service
public interface IAuthServer {

    /**
     * 查看所有的权限
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    List<AclAuth> getAll(StatusDto param);

    /**
     * 查看一个权限
     *
     * @param id 权限ID
     * @return status
     */
    AclAuth getOne(Integer id);

    /**
     * 修改权限信息
     *
     * @param params 权限信息
     * @return status
     */
    StatusDto updateOne(AclAuth params);

    /**
     * 添加权限
     *
     * @param params 权限信息
     * @return status
     */
    StatusDto addOne(AclAuth params);
}
