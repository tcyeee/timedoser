package com.timedoser.cloud.common.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 带有状态的通用DTO类
 *
 * @author huxiong
 * @date 2020/6/17 15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StatusDto extends PageBean {
    // 用于前端信息的接收
    private Integer status;
    private Integer type;

    // 用于返回信息的填充
    private String msg;
    private Boolean sta;

    public StatusDto(boolean sta) {
        this.sta = sta;
    }

    public StatusDto(boolean sta, String msg) {
        this.sta = sta;
        this.msg = msg;
    }
}
