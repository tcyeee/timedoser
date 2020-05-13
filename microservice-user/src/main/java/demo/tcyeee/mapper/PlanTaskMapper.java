package demo.tcyeee.mapper;

import demo.tcyeee.entity.vo.PlantaskList;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tcyeee
 * @date 2019/12/20 14:34
 */
@Mapper
public interface PlanTaskMapper {

    PlantaskList getTaskCount(String id);
}
