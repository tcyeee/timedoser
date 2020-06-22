package com.timedoser.cloud.common.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 带有状态的通用DTO类
 *
 * @author huxiong
 * @date 2020/6/17 15:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StatusDto extends PageBean {
    private Integer status;
    private Integer type;
    private String msg;
}
