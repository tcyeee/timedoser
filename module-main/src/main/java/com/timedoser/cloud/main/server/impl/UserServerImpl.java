package com.timedoser.cloud.main.server.impl;

import cn.hutool.core.codec.Base64;
import com.timedoser.cloud.common.entity.base.BaseUserInfo;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.base.StatusDto;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.common.utils.TokenUtils;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import com.timedoser.cloud.main.mapper.UserMapper;
import com.timedoser.cloud.main.server.IUserServer;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/22 16:17
 */
@Service
public class UserServerImpl implements IUserServer {
    @Resource
    private UserMapper userMapper;

    /**
     * 查看所有的用户
     *
     * @param param 1：可用，2：禁用
     * @return data
     */
    @Override
    public List<BaseUser> getAll(StatusDto param) {
        return null;
    }

    /**
     * 查看一个用户
     *
     * @param id 用户ID
     * @return status
     */
    @Override
    public BaseUser getOne(Integer id) {
        return null;
    }

    /**
     * 修改用户信息
     *
     * @param params 用户信息
     * @return status
     */
    @Override
    public StatusDto updateOne(BaseUser params) {
        return null;
    }

    /**
     * 添加用户
     *
     * @param params 用户信息
     * @return status
     */
    @Override
    public StatusDto addOne(BaseUser params) {
        return null;
    }


    /**
     * 获取个人信息
     *
     * @return userinfo
     */
    @Override
    public UserPasswordVo userInfo() {
        BaseUserInfo baseUserInfo = TokenUtils.baseInfo();
        return userMapper.info(baseUserInfo.getId());
    }
}
