package com.timedoser.cloud.user.service;

import com.timedoser.cloud.common.entity.po.User;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public interface UserService {
    User findByMobilephone(String userId);
}
