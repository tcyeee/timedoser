package com.timedoser.cloud.common.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MethodException extends RuntimeException {
    public MethodException(String msg) {
        super(msg);
    }
}
