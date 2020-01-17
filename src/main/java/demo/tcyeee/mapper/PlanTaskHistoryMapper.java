package demo.tcyeee.mapper;

import demo.tcyeee.entity.vo.ReportPageDataVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tcyeee
 * @date 2019/12/20 15:57
 */
@Mapper
public interface PlanTaskHistoryMapper {

    /**
     * report页面初始化需要的数据
     *
     * @param userId userId
     * @return data count
     */
    ReportPageDataVo pageData(String userId);
}
