package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import org.springframework.stereotype.Service;

/**
 * @author huxiong
 * @date 2020/6/18 16:17
 */
@Service
public interface ILoginServer {

    /**
     * 通过账号密码登录
     *
     * @param param param登录参数
     * @return 账号信息
     */
    Result userPassword(UserPasswordDto param);
}
