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
     * 获取用户创建的所有任务
     *
     * @param userId 用户id
     * @return data
     */
    List<PlanTask> findAllByUserId(String userId);
}
