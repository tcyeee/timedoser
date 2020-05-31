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

    AclUser findByMobilephone(@Param("mobilephone") String mobilephone);
}