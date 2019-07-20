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

    List<PlanTask> findAllByUserId(String userId);
}
