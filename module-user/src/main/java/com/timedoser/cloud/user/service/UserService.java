package com.timedoser.cloud.user.service;

import com.timedoser.cloud.common.entity.po.AclUser;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public interface UserService {

    /**
     * 通过手机号查看用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    AclUser findUserByPhone(String phoneNumber);
}
