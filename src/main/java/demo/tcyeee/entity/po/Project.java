package demo.tcyeee.entity.po;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chenyueee
 * @since 2020/1/20 22:55
 */
@Data
@Entity
@Builder
@DynamicInsert
@DynamicUpdate
public class Project {

    @Id
    private int id;

    // 项目名称(限定10个字以内)
    @Column(name = "name")
    private String name;

    // 图标 default 'like'
    @Column(name = "icon")
    private String icon;

    // 项目备注
    @Column(name = "remark")
    private String remark;

    // 背景颜色 default 'gray'
    @Column(name = "color")
    private String color;

    // 项目创建人
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser baseUser;

    // 项目状态(0:默认可用 1:已经删除)
    @Column(name = "status")
    private Integer status;

    // 总计所花费的时间(分钟)
    @Column(name = "sum_minute")
    private int sumMinute;

    // 创建项目的时间
    @Column(name = "create_date")
    private Timestamp createDate;

    @Tolerate
    public Project() {}
}
