package com.timedoser.cloud.common.entity.po;

import lombok.Data;
import java.util.Date;

/**
 * @author chenyueee
 * @since 2019/12/1 17:46
 */
@Data
public class AclRoleAuth {
    private int id;
    private AclRole aclRole;
    private AclAuth aclAuth;
    private Date createTime;
}
