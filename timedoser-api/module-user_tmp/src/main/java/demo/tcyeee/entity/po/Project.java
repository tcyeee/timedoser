package demo.tcyeee.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
    private String id;

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

    // 是否可用
    @Column(name = "create_type")
    private createTypeEnum createType;

    @Transient
    private boolean lastProject; // 标记最后一次使用的项目

    @Tolerate
    public Project() {
    }

    @Getter
    @AllArgsConstructor
    public enum createTypeEnum {
        err(0, "弃用位置"),
        defult(1, "手动添加"),
        auto(2, "新用户注册时候自动新建");

        private int index;
        private String remark;
    }
}
