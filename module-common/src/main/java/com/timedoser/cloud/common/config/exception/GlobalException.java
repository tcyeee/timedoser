package com.timedoser.cloud.common.config.exception;

import com.timedoser.cloud.common.entity.FlxedData;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.entity.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author tcyeee
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        log.error(FlxedData.PARAM_EXCEPTION_INFO, request.getRequestURI(), e);
        return Result.error(StatusCode.FEAILED);
    }

    /**
     * get参数校验异常
     *
     * @param e       exception
     * @param request request
     * @return {@link Result
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result businessExceptionHandler(ConstraintViolationException e, HttpServletRequest request) {
        String msg = StatusCode.PARAMS_ERROR.getReasonPhrase() + " " + e.getMessage();
        log.error(FlxedData.PARAM_EXCEPTION_INFO, request.getRequestURI());
        log.error(msg);
        return Result.error(StatusCode.PARAMS_ERROR.value(), msg);
    }

    /**
     * post参数校验异常
     *
     * @param e       exception
     * @param request request
     * @return {@link Result
     */
    @ExceptionHandler(BindException.class)
    public Result businessExceptionHandler(BindException e, HttpServletRequest request) {
        String msg = StatusCode.PARAMS_ERROR.getReasonPhrase() + " " + e.getMessage();
        log.error(FlxedData.PARAM_EXCEPTION_INFO, request.getRequestURI());
        log.error(msg);
        return Result.error(StatusCode.PARAMS_ERROR.value(), e.getBindingResult().getFieldError().getDefaultMessage());
    }


    /**
     * 请求方式异常
     *
     * @param e       exception
     * @param request request
     * @return {@link Result
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result requestMethodExceptionHandler(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String msg = StatusCode.REQUEST_METHOD_ERROR.getReasonPhrase() + " " + e.getMessage();
        log.error(FlxedData.PARAM_EXCEPTION_INFO, request.getRequestURI());
        log.error(msg);
        return Result.error(StatusCode.REQUEST_METHOD_ERROR.value(), msg);
    }
}
