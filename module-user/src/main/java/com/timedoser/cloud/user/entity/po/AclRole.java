package com.timedoser.cloud.user.entity.po;

import lombok.Data;
import java.util.Date;

/**
 * @author chenyueee
 * @since 2019/12/1 17:46
 */
@Data
public class AclRole {
    private int id;
    private String name;
    private String remark;
    private Date createTime;
}
