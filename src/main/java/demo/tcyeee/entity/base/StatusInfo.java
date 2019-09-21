package demo.tcyeee.entity.base;

import lombok.Data;

/**
 * 返回的状态信息
 *
 * @author chenyueee
 * @since 2019-09-21 15:13
 */
@Data
public class StatusInfo {

    private boolean status;
    private String message;

}