package com.timedoser.cloud.common.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @author chenyueee
 * @since 2019/12/1 17:46
 */
@Data
public class AclUserRole {
    private Long id;
    private String userId;
    private Integer roleId;
    private Date createTime;
}
