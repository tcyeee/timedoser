package demo.tcyeee.utils;

import demo.tcyeee.entity.base.PageBean;

/**
 * 分页工具类
 *
 * @author chenyueee
 * @since 2019-07-20 13:29
 */
public class PageUtils {

    /* 请求中存储分页的字段 */
    private static final String CURRENT_PAGE = "currentPage";
    private static final String PAGE_SIZE = "pageSize";


    /**
     * 获取PageBean对象
     *
     * @return PageBean 分页对象
     */
    public static PageBean getPageBean(PageBean pageBean) {
        int size = pageBean.getPageSize() != null ? pageBean.getPageSize() : 10;
        int temp = pageBean.getCurrentPage() != null ? pageBean.getCurrentPage() : 1;
        int start = (temp - 1) * size;
        return new PageBean(start, size);
    }

    /**
     * 获取PageBean对象
     *
     * @param currentPage 当前页面
     * @param pageSize    页面数量
     * @return data
     */
    public static PageBean getPageBean(Integer currentPage, Integer pageSize) {

        int size = pageSize != null ? pageSize : 10;
        int start = currentPage != null ? (currentPage - 1) * size : 0;
        return new PageBean(start, size);
    }

}
