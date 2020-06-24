package com.timedoser.cloud.common.entity;

/**
 * @author huxiong
 * @date 2020/6/17 14:35
 */
public final class FlxedData {

    public static final String PARAM_EXCEPTION_INFO = "请求路径: {}";
    public static final String TOKEN_ERROR = "token解析失败!";

    public static final String LOGIN_ERROR = "账号或者密码错误!!";


    /* 用户信息修改 */
    public static String userUpdate(boolean status) {
        final String success = "用户信息修改成功!!";
        final String error = "用户信息修改失败!!";
        return status ? success : error;
    }

    /* 角色信息修改 */
    public static String roleUpdate(boolean status) {
        final String success = "角色信息修改成功!!";
        final String error = "角色信息修改失败!!";
        return status ? success : error;
    }

    /* 权限信息修改 */
    public static String authUpdate(boolean status) {
        final String success = "权限信息修改成功!!";
        final String error = "权限信息修改失败!!";
        return status ? success : error;
    }
}
