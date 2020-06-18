package com.timedoser.cloud.main.server.impl;

import cn.hutool.core.codec.Base64;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import com.timedoser.cloud.main.mapper.AclUserMapper;
import com.timedoser.cloud.main.server.LoginServer;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
    public AclUser userPassword(UserPasswordDto param) {
        String basePassword = Base64.decodeStr(param.getPassword());
        String password = DigestUtils.md5DigestAsHex(basePassword.getBytes()).toUpperCase();
        return aclUserMapper.userPassword(param.getPhoneNumber(), password);
    }
}
