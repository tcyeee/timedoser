package demo.tcyeee.service.impl;

import demo.tcyeee.dao.PlanTaskHistoryDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.ReportPageDataVo;
import demo.tcyeee.service.ReportService;
import demo.tcyeee.utils.BaseUtils;
import demo.tcyeee.utils.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyueee
 * @since 2019-09-22 20:20
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private PlanTaskHistoryDao planTaskHistoryDao;

    /**
     * report页面初始化需要的数据
     *
     * @return pageData
     */
    @Override
    public ReportPageDataVo pageData() {
        BaseUser baseUser = BaseUtils.userInfo();
        List<Object[]> objects = planTaskHistoryDao.diyPageData(baseUser.getId());
        return EntityUtils.castEntity(objects, ReportPageDataVo.class).get(0);
    }
}
