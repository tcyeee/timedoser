package com.timedoser.cloud.main.server;

import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/17 16:25
 */
@Service
public interface IUserServer {

    /**
     * 查看所有的用户
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    List<BaseUser> getAll(StatusDto param);

    /**
     * 查看一个用户
     *
     * @param id 用户ID
     * @return status
     */
    BaseUser getOne(Integer id);

    /**
     * 修改用户信息
     *
     * @param params 用户信息
     * @return status
     */
    StatusDto updateOne(BaseUser params);

    /**
     * 添加用户
     *
     * @param params 用户信息
     * @return status
     */
    StatusDto addOne(BaseUser params);

    /**
     * 获取个人信息
     *
     * @return userinfo
     */
    UserPasswordVo userInfo();
}
