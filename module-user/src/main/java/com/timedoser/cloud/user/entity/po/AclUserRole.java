package com.timedoser.cloud.user.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenyueee
 * @since 2019/12/1 17:46
 */
@Data
@Entity
@Table(name = "acl_user_role", schema = "time_doser_user")
public class AclUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AclUser baseUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private AclRole aclRole;

    @Column(name = "create_time")
    private Date createTime;
}
