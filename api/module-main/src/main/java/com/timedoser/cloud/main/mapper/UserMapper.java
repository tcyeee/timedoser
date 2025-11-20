package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huxiong
 * @date 2020/6/17 16:28
 */
public interface UserMapper extends BaseMapper<BaseUser> {

    /**
     * 查看用户信息
     *
     * @param id id
     * @return user info
     */
    UserPasswordVo info(@Param("id") String id);

    /**
     * 查看所有的用户
     *
     * @param status 1：可用，2：禁用
     * @return data
     */
    Page<BaseUser> getAll(@Param("page") Page<?> page, @Param("status") Integer status);
}
