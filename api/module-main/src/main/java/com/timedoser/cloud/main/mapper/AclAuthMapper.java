package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timedoser.cloud.common.entity.po.AclAuth;
import com.timedoser.cloud.common.entity.po.BaseUser;

import java.util.List;

/**
 * @author tcyeee
 * @date 2020/6/24 7:52 上午
 */
public interface AclAuthMapper extends BaseMapper<AclAuth> {
    List<AclAuth> getAll(Page<BaseUser> page, Integer status);
}
