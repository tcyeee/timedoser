package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timedoser.cloud.common.entity.po.AclUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author huxiong
 * @date 2020/6/18 16:20
 */
public interface AclUserMapper extends BaseMapper<AclUser> {

    /**
     * 通过手机号查询
     *
     * @param phoneNumber phoneNumber
     * @param password password
     * @return data
     */
    AclUser userPassword(@Param("phoneNumber") String phoneNumber, @Param("password") String password);
}
