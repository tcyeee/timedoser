package com.timedoser.cloud.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.BaseUser;
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
    BaseUser findUserByPhone(String phoneNumber);

    BaseUser getInfo(String id);

    IPage<BaseUser> selectPageVo(StatusDto param);
}
