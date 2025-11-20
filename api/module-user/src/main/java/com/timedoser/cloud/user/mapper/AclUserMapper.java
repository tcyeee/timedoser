package com.timedoser.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.po.BaseUser;
import org.apache.ibatis.annotations.Param;

public interface AclUserMapper extends BaseMapper<BaseUser> {

    /**
     * 通过phoneNumber获得用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    BaseUser findUserByPhone(@Param("phoneNumber") String phoneNumber);

    IPage<BaseUser> selectPageVo(Page<?> page);
}