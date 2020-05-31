package com.timedoser.cloud.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.timedoser.cloud.common.entity.po.User;
import com.timedoser.cloud.user.entity.po.AclUser;
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
    private AclUserDao userDao;

    @Override
    public User findByMobilephone(String mobilephone) {
        AclUser acl = userDao.findByMobilephone(mobilephone);
        User result = new User();
        BeanUtil.copyProperties(acl, result);
        return result;
    }
}
