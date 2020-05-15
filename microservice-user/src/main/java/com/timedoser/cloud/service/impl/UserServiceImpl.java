package com.timedoser.cloud.service.impl;

import com.timedoser.cloud.dao.AclUserDao;
import com.timedoser.cloud.entity.po.AclUser;
import com.timedoser.cloud.service.UserService;
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
    public AclUser findByMobilephone(String mobilephone) {
        return userDao.findByMobilephone(mobilephone);
    }
}
