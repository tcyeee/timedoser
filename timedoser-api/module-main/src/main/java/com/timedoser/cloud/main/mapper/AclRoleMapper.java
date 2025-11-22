package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.po.AclRole;
import com.timedoser.cloud.common.entity.po.BaseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huxiong
 * @date 2020/6/18 17:52
 */
public interface AclRoleMapper extends BaseMapper<AclRole> {
    List<AclRole> findByUserId(@Param("id") String id);

    /**
     * 查看所有的角色
     *
     * @param status 1：可用，2：禁用
     * @return data
     */
    List<AclRole> getAll(Page<BaseUser> page, Integer status);
}
