package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timedoser.cloud.common.entity.po.AclRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/18 17:52
 */
public interface AclRoleMapper extends BaseMapper<AclRole> {
    List<AclRole> findByUserId(@Param("id") String id);
}
