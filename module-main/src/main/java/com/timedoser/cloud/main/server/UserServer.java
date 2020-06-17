package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.AclUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/17 16:25
 */
@Service
public interface UserServer {
    List<AclUser> findAll(StatusDto param);
}
