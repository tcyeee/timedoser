package com.timedoser.cloud.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timedoser.cloud.common.entity.po.AclUser;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huxiong
 * @date 2020/6/17 16:28
 */
public interface UserMapper extends BaseMapper<AclUser> {
    UserPasswordVo info(@Param("id") String id);
}
