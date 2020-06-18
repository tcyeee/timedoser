package com.timedoser.cloud.main.server.impl;

import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import com.timedoser.cloud.main.mapper.AclUserMapper;
import com.timedoser.cloud.main.server.LoginServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/18 16:17
 */
@Service
public class LoginServerImpl implements LoginServer {

    @Resource
    private AclUserMapper aclUserMapper;

    /**
     * 通过账号密码登录
     *
     * @param param param登录参数
     * @return 账号信息
     */
    @Override
    public AclUser userPassword(UserPasswordVo param) {
        return aclUserMapper.findByPhone(param.getPhoneNumber());
    }
}
