package demo.tcyeee.service.impl;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.ReportPageDataVo;
import demo.tcyeee.mapper.PlanTaskHistoryMapper;
import demo.tcyeee.service.ReportService;
import demo.tcyeee.utils.BaseUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyueee
 * @since 2019-09-22 20:20
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private PlanTaskHistoryMapper planTaskHistoryMapper;

    /**
     * report页面初始化需要的数据
     *
     * @return pageData
     */
    @Override
    public ReportPageDataVo pageData() {
        BaseUser baseUser = BaseUtils.userInfo();
        return planTaskHistoryMapper.pageData(baseUser.getId());
    }
}
