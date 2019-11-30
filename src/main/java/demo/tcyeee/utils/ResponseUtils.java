package demo.tcyeee.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import demo.tcyeee.entity.base.StatusResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 格式化返回的参数
 *
 * @author tcyeee
 * @since 2019-04-29
 */
public final class ResponseUtils {

    @Getter
    @AllArgsConstructor
    public enum ReturnCode {

        SUCCESS(200, "操作成功!!"),
        NODATA(201, "查询成功,但是查询记录为空!"),
        FEAILED(300, "操作失败!!"),
        PARAMS_ERROR(301, "参数为空或格式错误,请检查!!"),
        PERMISSION_DISABLE(400, "缺少权限!");

        private Integer code;
        private String msg;
    }


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
    public static final String LOGIN_ERROR_MSG = "请重新登录!";


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
    public static String creatStatusResponse(StatusResult status) {
        Map<String, Object> result = new HashMap<>();
        result.put(STATUS_KEY, status.isStatus());
        result.put(CODE_KEY, status.isStatus() ? ReturnCode.SUCCESS.code : ReturnCode.FEAILED.code);
        result.put(MSG_KEY, status.getMessage());
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
        result.put(CODE_KEY, ReturnCode.SUCCESS.code);
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
        result.put(CODE_KEY, ReturnCode.FEAILED.code);
        result.put(MSG_KEY, ReturnCode.FEAILED.msg);
        return JSON.toJSONString(result);
    }

    /**
     * 返回错误信息
     *
     * @return data
     */
    public static String creatErrResponse() {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, ReturnCode.FEAILED.code);
        result.put(MSG_KEY, ReturnCode.FEAILED.msg);
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
        result.put(CODE_KEY, ReturnCode.FEAILED.code);
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
    public static String creatErrResponse(ReturnCode code, String msg) {
        Map<String, Object> result = markError();
        result.put(CODE_KEY, code.code);
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
        result.put(CODE_KEY, ReturnCode.NODATA.code);
        result.put(MSG_KEY, ReturnCode.NODATA.msg);
        result.put(STATUS_KEY, true);
        return result;
    }

    // 查询成功且有数据
    private static Map<String, Object> markSuccess(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put(CODE_KEY, ReturnCode.SUCCESS.code);
        result.put(MSG_KEY, ReturnCode.SUCCESS.msg);
        result.put(STATUS_KEY, true);
        result.put(DATA_KEY, data);
        return result;
    }
}
