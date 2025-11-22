package com.timedoser.cloud.common.entity.base;

import lombok.Data;

/**
 * token中存储的userInfo
 *
 * @author huxiong
 * @date 2020/6/19 09:42
 */
@Data
public class BaseUserInfo {
    private String id;
    private Integer enable;                // 账户状态
    private String mobilephone;            // 手机号
    private String authoritiesString;      // 角色列表
}
