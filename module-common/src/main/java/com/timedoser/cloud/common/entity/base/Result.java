package com.timedoser.cloud.common.entity.base;

//import com.github.pagehelper.PageInfo;

import com.timedoser.cloud.common.entity.enums.StatusCode;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回参数构建
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    // ---------------- 返回值构建 key ---------------
    private static final String MSG = "msg";
    private static final String STATUS = "status";
    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String TOTAL = "total";

    public Result() {
        put(STATUS, true);
        put(MSG, StatusCode.SUCCESS.getReasonPhrase());
        put(CODE, HttpStatus.OK.value());
    }

    //-------------------------------- 创建错误模板 ------------
    public static Result error() {
        return error(StatusCode.FEAILED);
    }

    public static Result error(StatusCode status) {
        return error(status.value(), status.getReasonPhrase());
    }

    public static Result error(String msg) {
        return error(StatusCode.FEAILED.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put(CODE, code);
        result.put(MSG, msg);
        result.put(STATUS, false);
        return result;
    }


    //-------------------------------- 创建成功模板 ------------
    public static Result ok() {
        return new Result();
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put(MSG, msg);
        result.put(STATUS, true);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.put(DATA, map);
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.put(DATA, data);
        return result;
    }

    //-------------------------------- 创建分页模板 ------------
//    public static Result page(PageInfo<Object> data) {
//        Result result = new Result();
//        result.put(TOTAL, data.getTotal());
//        result.put(DATA, data.getList());
//        return result;
//    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
