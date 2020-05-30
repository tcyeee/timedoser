package com.timedoser.cloud.eureka.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 格式化返回的参数
 *
 * @author tcyeee
 * @since 2019-04-29
 */
public final class ResponseUtils {

    /* 返回数据时候的类型 数据和数据总数 */
    private static final String CODE_KEY = "code";
    private static final String DATA_KEY = "data";
    private static final String COUNT_KEY = "count";
    private static final String MSG_KEY = "msg";
    private static final String STATUS_KEY = "status";

    /* 固定参数数据 */
    public static final String PARAMS_ERROR_INFO = "请检查传入的字段:";
    public static final String MESSAGE_ERROR_INFO = "留言信息不可为空";
    public static final String ACCESS_ERROR_MSG = "无访问权限!";
    public static final String LOGIN_ERROR_MSG = "操作失败!";
    public static final String NO_CONTENT = "返回数据为空!";
    public static final String SUCCESS = "操作成功!";
    public static final String ERROR = "操作失败!";


    /**
     * 打包返回json格式文件
     *
     * @param data 前端页面需要的返回数据
     * @return resultData
     */
    public static String creatJsonResponse(Object data) {
        Map<String, Object> result = data == null ? markSuccessButNoData() : markSuccess(data);
        return JSON.toJSONString(result);
    }

    /**
     * 返回自定义状态数据
     *
     * @param status 状态信息
     * @return data
     */
    public static String creatStatusResponse(boolean status) {
        Map<String, Object> result = new HashMap<>();
        result.put(STATUS_KEY, status);
        result.put(CODE_KEY, status ? HttpStatus.OK.value() : NO_CONTENT);
        return JSON.toJSONString(result);
    }

    /**
     * 返回自定义状态数据
     *
     * @param status 状态信息
     * @return data
     */
    public static String creatStatusResponse(boolean status, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put(STATUS_KEY, status);
        result.put(CODE_KEY, status ? HttpStatus.OK.value() : ERROR);
        result.put(MSG_KEY, message);
        return JSON.toJSONString(result);
    }

    /**
     * 打包返回分页信息
     *
     * @param data 前端页面需要的返回数据
     * @return resultData
     */
    public static String creatPageResponse(PageInfo<Object> data) {
        Map<String, Object> result = new HashMap<>();
        result.put(STATUS_KEY, true);
        result.put(CODE_KEY, HttpStatus.OK.value());
        result.put(COUNT_KEY, data.getTotal());
        result.put(DATA_KEY, data.getList());
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }


    /**
     * 返回成功信息
     *
     * @return data
     */
    public static String creatSuccessResponse() {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, HttpStatus.OK.value());
        result.put(MSG_KEY, SUCCESS);
        return JSON.toJSONString(result);
    }

    /**
     * 返回错误信息
     *
     * @return data
     */
    public static String creatErrResponse() {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, ERROR);
        result.put(MSG_KEY, LOGIN_ERROR_MSG);
        return JSON.toJSONString(result);
    }

    /**
     * 返回错误信息
     *
     * @param msg 状态信息
     * @return data
     */
    public static String creatErrResponse(String msg) {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, ERROR);
        result.put(MSG_KEY, msg);
        return JSON.toJSONString(result);
    }

    /**
     * 返回错误信息
     *
     * @param code 状态信息
     * @param msg  错误信息
     * @return data
     */
    public static String creatErrResponse(HttpStatus code, String msg) {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, code.value());
        result.put(MSG_KEY, msg);
        return JSON.toJSONString(result);
    }

    // --------------------------------------  模板  ----------------------------------------------

    // 错误模板
    private static Map<String, Object> markError() {
        Map<String, Object> result = new HashMap<>();
        result.put(STATUS_KEY, false);
        return result;
    }

    // 查询成功但没数据
    private static Map<String, Object> markSuccessButNoData() {
        Map<String, Object> result = new HashMap<>();
        result.put(CODE_KEY, NO_CONTENT);
        result.put(MSG_KEY, NO_CONTENT);
        result.put(STATUS_KEY, true);
        return result;
    }

    // 查询成功且有数据
    private static Map<String, Object> markSuccess(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put(CODE_KEY, HttpStatus.OK.value());
        result.put(MSG_KEY, SUCCESS);
        result.put(STATUS_KEY, true);
        result.put(DATA_KEY, data);
        return result;
    }
}
