package com.timedoser.cloud.main.server.impl;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.mapper.UserMapper;
import com.timedoser.cloud.main.server.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/17 16:25
 */
@Service
public class UserServerImpl implements UserServer {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<AclUser> findAll(StatusDto param) {
        return null;
    }
}
