package demo.tcyeee.dao;

import demo.tcyeee.entity.po.PlanTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenyueee
 * @since 2019-07-20 19:17
 */
@Repository
public interface PlanTaskDao extends CrudRepository<PlanTask, Long> {

    /**
     * 获取用户创建的所有未删除的任务
     *
     * @param userId userId
     * @param type   不等于9 / 没有被删除
     * @return data
     */
    List<PlanTask> findAllByUserIdAndTypeIsNot(String userId, int type);
}
