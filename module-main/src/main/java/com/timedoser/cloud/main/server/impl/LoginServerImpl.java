package com.timedoser.cloud.main.server.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import com.timedoser.cloud.main.mapper.AclRoleMapper;
import com.timedoser.cloud.main.mapper.AclUserMapper;
import com.timedoser.cloud.main.server.LoginServer;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/18 16:17
 */
@Service
public class LoginServerImpl implements LoginServer {

    @Resource
    private AclUserMapper aclUserMapper;
    @Resource
    private AclRoleMapper roleMapper;

    /**
     * 通过账号密码登录
     *
     * @param param param登录参数
     * @return 账号信息
     */
    @Override
    public UserPasswordVo userPassword(UserPasswordDto param) {

        // base info
        UserPasswordVo result = new UserPasswordVo();
        String basePassword = Base64.decodeStr(param.getPassword());
        String password = DigestUtils.md5DigestAsHex(basePassword.getBytes()).toUpperCase();
        AclUser user = aclUserMapper.userPassword(param.getPhoneNumber(), password);
        BeanUtil.copyProperties(user, result);

        // auth
        List<AclRole> roleList = roleMapper.findByUserId(user.getId());
        return result;
    }
}
