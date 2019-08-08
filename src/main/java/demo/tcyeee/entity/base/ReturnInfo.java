package demo.tcyeee.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 统一后端接口返回对象
 *
 * @author tcyeee
 * @since 2019-05-05 16:48
 */
@Data
public class ReturnInfo {

    private boolean success;    // 是否成功
    private String code;        /** {@link ReturnInfo.ReturnCode} */
    private String msg;         // 返回信息
    private Object data;        // 返回数据

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


    /**
     * 查询成功且有数据
     *
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markSuccess(Object data) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(true);
        returnInfo.setCode(ReturnCode.SUCCESS.getCode());
        returnInfo.setMsg(ReturnCode.SUCCESS.getMsg());
        returnInfo.setData(data);
        return returnInfo;
    }

    /**
     * 自定义返回结果
     * 建议使用统一的返回结果，特殊情况可以使用此方法
     *
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markCustom(boolean success, String code, String msg, String data) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(success);
        returnInfo.setCode(code);
        returnInfo.setMsg(msg);
        returnInfo.setData(data);
        return returnInfo;
    }


    /**
     * 自定义查询查询失败状态信息
     *
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markError() {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(false);
        returnInfo.setCode(ReturnCode.FEAILED.getCode());
        returnInfo.setMsg(ReturnCode.FEAILED.getMsg());
        returnInfo.setData(null);
        return returnInfo;
    }

    /**
     * 自定义查询查询失败状态信息
     *
     * @param code 错误信息码
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markError(ReturnCode code) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(false);
        returnInfo.setCode(code.getCode());
        returnInfo.setMsg(code.getMsg());
        returnInfo.setData(null);
        return returnInfo;
    }

    /**
     * 自定义查询查询失败状态信息
     *
     * @param code 错误信息码
     * @param msg  错误信息
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markError(ReturnCode code, String msg) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(false);
        returnInfo.setCode(code.getCode());
        returnInfo.setMsg(code.getMsg());
        returnInfo.setData(msg);
        return returnInfo;
    }

    /**
     * 查询成功但无数据
     *
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markSuccessButNoData() {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(true);
        returnInfo.setCode(ReturnCode.NODATA.getCode());
        returnInfo.setMsg(ReturnCode.NODATA.getMsg());
        returnInfo.setData(null);
        return returnInfo;
    }


}
