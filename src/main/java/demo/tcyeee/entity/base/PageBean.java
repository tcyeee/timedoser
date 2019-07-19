package demo.tcyeee.entity.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 分页组件
 *
 * @author tcyeee
 * @since 2019-04-29
 */
@SuppressWarnings("unused")
@Data
public class PageBean implements Serializable {
    private static final long serialVersionUID = -1855574134779989167L;

    private Integer currentPage = 1;  // 当前页
    private Integer pageSize = 20;    // 页面尺寸
    private Integer pageCount;        // 总共页数
    private long recordCount;         // 总行数
    private Integer lastPageSize;     // 最后一页行数
    private Integer startRow;         // 开始行数

    /**
     * 创建新页面
     *
     * @param currentPage 当前页
     * @param pageSize    页面尺寸
     */
    public PageBean(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}



