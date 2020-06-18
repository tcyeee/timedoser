package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import org.springframework.stereotype.Service;

/**
 * @author huxiong
 * @date 2020/6/18 16:17
 */
@Service
public interface LoginServer {

    /**
     * 通过账号密码登录
     *
     * @param param param登录参数
     * @return 账号信息
     */
    AclUser userPassword(UserPasswordVo param);
}
