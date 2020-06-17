package com.timedoser.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.user.mapper.AclUserMapper;
import com.timedoser.cloud.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AclUserMapper userMapper;


    /**
     * 通过手机号查看用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    @Override
    public AclUser findUserByPhone(String phoneNumber) {
        return userMapper.findUserByPhone(phoneNumber);
    }

    @Override
    public AclUser getInfo(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public IPage<AclUser> selectPageVo(StatusDto param) {
        Page<AclUser> aclUserPage = new Page<>(param.getCurrentPage(), param.getPageSize());
        return userMapper.selectPageVo(aclUserPage);
    }
}
