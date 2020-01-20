package demo.tcyeee.entity.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author chenyueee
 * @since 2020/1/20 22:55
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Project {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;

    @Column(name = "remark")
    private String remark;

    @Column(name = "color")
    private String color;

    @Column(name = "base_user_id")
    private String baseUserId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "sum_minute")
    private int sumMinute;

    @Column(name = "create_date")
    private Timestamp createDate;
}
