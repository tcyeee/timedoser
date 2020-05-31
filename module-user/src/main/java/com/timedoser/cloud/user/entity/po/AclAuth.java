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
@Table(name = "acl_auth", schema = "time_doser_user")
public class AclAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;

    @Column(name = "create_time")
    private Date createTime;


}
