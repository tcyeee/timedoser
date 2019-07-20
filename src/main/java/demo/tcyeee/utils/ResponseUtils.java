package demo.tcyeee.utils;

import com.alibaba.fastjson.JSON;
import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.base.ReturnInfo;
import demo.tcyeee.entity.enums.base.ReturnCode;
import demo.tcyeee.entity.vo.BaseInfoVo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
    private static final String DATA_KEY = "Data";
    private static final String COUNT_KEY = "Count";


    /**
     * 打包返回json格式文件
     *
     * @param data 前端页面需要的返回数据
     * @return resultData
     */
    public static String creatJsonResponse(Object data) {
        ReturnInfo info = data == null ? ReturnInfo.markSuccessButNoData() : ReturnInfo.markSuccess(data);
        return JSON.toJSONString(info);
    }

    /**
     * 返回自定义信息
     *
     * @param info 自定义信息 {@link ReturnInfo}
     * @return data
     */
    public static String creatResponse(ReturnInfo info) {
        return JSON.toJSONString(info);
    }

    /**
     * 打包返回json格式文件(带分页)
     *
     * @param data  前端页面需要的返回数据
     * @param count 返回数据的总条数
     * @return resultData
     */
    public static String creatJsonResponse(Object data, int count) {
        Map<String, Object> resultData = new HashMap<>();
        resultData.put(DATA_KEY, data);
        resultData.put(COUNT_KEY, count);

        ReturnInfo info = ReturnInfo.markSuccess(resultData);
        return JSON.toJSONString(info);
    }

    /**
     * 打包返回空数据模板
     *
     * @return resultData
     */
    public static String creatErrResponse() {
        return JSON.toJSONString(ReturnInfo.markError());
    }

    /**
     * 创建错误返回信息模板
     *
     * @param code 状态信息
     * @return data
     */
    public static String creatErrResponse(ReturnCode code) {
        return JSON.toJSONString(ReturnInfo.markError(code));
    }

    /**
     * 创建错误返回信息模板
     *
     * @param code 状态信息
     * @param msg  错误信息
     * @return data
     */
    public static String creatErrResponse(ReturnCode code, String msg) {
        return JSON.toJSONString(ReturnInfo.markError(code, msg));
    }
}
