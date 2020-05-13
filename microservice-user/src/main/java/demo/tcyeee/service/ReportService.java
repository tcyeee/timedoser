package demo.tcyeee.service;

import demo.tcyeee.entity.vo.ReportPageDataVo;
import org.springframework.stereotype.Service;

/**
 * @author chenyueee
 * @since 2019-09-22 20:20
 */
@Service
public interface ReportService {

    /**
     * report页面初始化需要的数据
     *
     * @return pageData
     */
    ReportPageDataVo pageData();
}
