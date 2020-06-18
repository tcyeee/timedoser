package com.timedoser.cloud.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * 在基础上添加详细说明
 *
 * @author tcyeee
 * @see HttpStatus 参照这个写的
 */
@Getter
@AllArgsConstructor
public enum StatusCode {

    // ------ 默认返回 -------
    SUCCESS(1200, "success!"),
    FEAILED(1201, "fail!"),
    NODATA(1203, "查询记录为空!"),

    // ------ 前端校验 ---------
    PARAMS_ERROR(1300, "参数异常"),
    PARAMS_Empty(1301, "请求参数为空"),
    ELECTION_VALUE_LENGTH_ERROR(1302, "参数字段长度超出限制"),
    REQUEST_METHOD_ERROR(1303, "请求方式错误"),

    // ------ 权限 ---------
    SIGN_ERROR(1400, "数据签名错误!"),
    NO_ACCESS(1401, "没有权限"),
    ACCOUNT_ERROR(1402, "账户不存在或被禁用"),
    API_DISABLE(1403, "没有查询权限"),
    NO_LOGIN(1404, "未登陆或登录过期，请重新登录"),

    // ------ 安全 ---------
    UNKNOWN_IP(1500, "非法IP请求!");

    private final int value;
    private final String reasonPhrase;

    public int value() {
        return this.value;
    }
}
