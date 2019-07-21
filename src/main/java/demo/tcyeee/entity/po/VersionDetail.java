package demo.tcyeee.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 版本升级信息
 *
 * @author chenyueee
 * @since 2019-07-21 10:36
 */
@Data
@Entity
@Table(name = "version_detail", schema = "demo_springCloud")
public class VersionDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 32, updatable = false)
    private int id;

    /** 创建时间 */
    @Column(name = "createdate", columnDefinition = "datetime DEFAULT current_timestamp")
    private Date createdate;

    /** 更新内容 */
    @Column(name = "context", length = 64)
    private String context;

    /** 更新细节 */
    @Column(name = "detail", length = 500)
    private String detail;

    /** 版本号 */
    @Column(name = "version", unique = true, length = 32)
    private String version;

    /** 图片地址 */
    @Column(name = "img_url")
    private String imgUrl;
}
