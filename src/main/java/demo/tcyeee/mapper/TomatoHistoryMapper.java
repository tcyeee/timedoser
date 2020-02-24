package demo.tcyeee.mapper;

import demo.tcyeee.entity.po.TomatoHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author chenyueee
 * @since 2020/2/24 16:26
 */
@Mapper
public interface TomatoHistoryMapper {

    /**
     * 拿到最近的一次任务
     *
     * @param userId user id
     * @return project history
     */
    TomatoHistory getLastHistory(@Param("userId") String userId);
}
