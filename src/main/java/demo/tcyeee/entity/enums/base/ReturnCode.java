package demo.tcyeee.entity.enums.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回参数枚举
 *
 * @author tcyeee
 * @since 2019-05-05 16:57
 */
@Getter
@AllArgsConstructor
public enum ReturnCode {

    SUCCESS("000", "查询成功!"),
    FEAILED("001", "查询失败!"),

    PARAMS_ERROR("002", "参数为空或格式错误,请检查!"),
    NODATA("003", "查询记录为空!"),

    API_DISABLE("004", "没有查询权限!"),
    UNKNOWN_IP("005", "非法IP请求!"),
    SYSTEM_ERROR("006", "系统异常!"),
    SIGN_ERROR("007", "数据签名错误!"),
    API_NOT_EXISTS("008", "请求的接口不存在"),
    API_NOT_PER("009", "没有该接口的访问权限"),
    ACCOUNT_ERROR("100", "账户不存在或被禁用"),
    AMOUNT_NOT_QUERY("101", "余额不够，无法进行查询");

    private String code;
    private String msg;
}
