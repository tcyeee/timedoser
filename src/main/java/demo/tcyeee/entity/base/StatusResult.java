package demo.tcyeee.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author huxiong
 * @date 2019-08-07 16:35
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusResult {

    private boolean status;
    private String message;

    private static final String SUCCESS = "操作成功!!";
    private static final String ERROR = "操作失败!!";


    /**
     * 创建成功的返回信息
     *
     * @return status
     */
    public static StatusResult creatSuccessInfo() {
        StatusResult result = new StatusResult();
        result.setStatus(true);
        result.setMessage(SUCCESS);
        return result;
    }

    public static StatusResult creatSuccessInfo(String msg) {
        StatusResult result = new StatusResult();
        result.setStatus(true);
        result.setMessage(msg);
        return result;
    }

    /**
     * 创建错误的返回信息
     *
     * @return status
     */
    public static StatusResult creatErrorInfo() {
        StatusResult result = new StatusResult();
        result.setStatus(false);
        result.setMessage(ERROR);
        return result;
    }

    public static StatusResult creatErrorInfo(String msg) {
        StatusResult result = new StatusResult();
        result.setStatus(false);
        result.setMessage(msg);
        return result;
    }


}
