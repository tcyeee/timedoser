package demo.tcyeee.entity.base;

import demo.tcyeee.entity.enums.base.ReturnCodeList;
import lombok.Data;

/**
 * 统一后端接口返回对象
 *
 * @author tcyeee
 * @since 2019-05-05 16:48
 */
@Data
public class ReturnInfo {

    /** 是否成功 */
    private boolean success;

    /** 返回码 {@link ReturnCodeList.ReturnCode} */
    private String code;

    /** 返回信息 */
    private String msg;

    /** 返回数据 */
    private Object data;


    /**
     * 查询成功且有数据
     *
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markSuccess(Object data) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setSuccess(true);
        returnInfo.setCode(ReturnCodeList.ReturnCode.SUCCESS.getCode());
        returnInfo.setMsg(ReturnCodeList.ReturnCode.SUCCESS.getMsg());
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
        returnInfo.setCode(ReturnCodeList.ReturnCode.FEAILED.getCode());
        returnInfo.setMsg(ReturnCodeList.ReturnCode.FEAILED.getMsg());
        returnInfo.setData(null);
        return returnInfo;
    }

    /**
     * 自定义查询查询失败状态信息
     *
     * @param code 错误信息码
     * @return {@link ReturnInfo}
     */
    public static ReturnInfo markError(ReturnCodeList.ReturnCode code) {
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
    public static ReturnInfo markError(ReturnCodeList.ReturnCode code, String msg) {
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
        returnInfo.setCode(ReturnCodeList.ReturnCode.NODATA.getCode());
        returnInfo.setMsg(ReturnCodeList.ReturnCode.NODATA.getMsg());
        returnInfo.setData(null);
        return returnInfo;
    }


}
