package com.timedoser.cloud.user.service;

import com.timedoser.cloud.user.entity.po.AclUser;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public interface UserService {
    AclUser findByMobilephone(String userId);
}
