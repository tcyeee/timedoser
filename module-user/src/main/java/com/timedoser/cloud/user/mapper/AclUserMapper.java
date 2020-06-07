package com.timedoser.cloud.user.mapper;

import com.timedoser.cloud.common.entity.po.AclUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AclUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AclUser record);

    int insertSelective(AclUser record);

    AclUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AclUser record);

    int updateByPrimaryKey(AclUser record);

    /**
     * 通过phoneNumber获得用户信息
     *
     * @param phoneNumber 手机号
     * @return userInfo
     */
    AclUser findUserByPhone(@Param("phoneNumber") String phoneNumber);
}