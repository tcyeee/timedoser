package demo.tcyeee.utils;

import demo.tcyeee.entity.base.PageBean;

import javax.servlet.http.HttpServletRequest;

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
     * @param request 请求对象
     * @return PageBean 分页对象
     */
    public static PageBean getPageBean(HttpServletRequest request) {
        String currentPage = request.getParameter(CURRENT_PAGE);
        String pageSize = request.getParameter(PAGE_SIZE);

        int start = currentPage != null ? Integer.valueOf(currentPage) : 1;
        int limit = pageSize != null ? Integer.valueOf(pageSize) : 10;
        return new PageBean(start, limit);
    }
}
