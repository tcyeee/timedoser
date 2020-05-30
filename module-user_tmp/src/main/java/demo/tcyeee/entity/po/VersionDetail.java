package demo.tcyeee.entity.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 版本升级信息
 *
 * @author tcyeee
 * @since 2019-07-21 10:36
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "version_detail")
public class VersionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 32, updatable = false)
    private int id;

    // 创建时间
    @Column(columnDefinition = "timestamp DEFAULT current_timestamp")
    private Date createdate;

    // 更新内容
    @Column(length = 64)
    private String context;

    // 更新细节
    private String detail;

    // 版本号
    @Column(unique = true, length = 32)
    private String version;

    // 图片地址
    private String imgUrl;
}
