package demo.tcyeee.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenyueee
 * @since 2019/12/1 17:46
 */
@Data
@Entity
@Table(name = "acl_role_auth", schema = "time_doser")
public class AclRoleAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private AclRole aclRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id")
    private AclAuth aclAuth;

    @Column(name = "create_time")
    private Date createTime;

}
