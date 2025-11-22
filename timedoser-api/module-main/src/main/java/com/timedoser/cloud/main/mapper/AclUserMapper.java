package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timedoser.cloud.common.entity.po.BaseUser;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huxiong
 * @date 2020/6/18 16:20
 */
public interface AclUserMapper extends BaseMapper<BaseUser> {

    /**
     * 通过手机号查询
     *
     * @param phoneNumber phoneNumber
     * @param password    password
     * @return data
     */
    UserPasswordVo userPassword(@Param("phoneNumber") String phoneNumber, @Param("password") String password);
}
