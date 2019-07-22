package demo.tcyeee.entity.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 分页组件
 *
 * @author tcyeee
 * @since 2019-04-29
 */
@Data
public class PageBean implements Serializable {
    private static final long serialVersionUID = -1855574134779989167L;

    private Integer currentPage;  // 当前页
    private Integer pageSize;     // 页面尺寸

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



