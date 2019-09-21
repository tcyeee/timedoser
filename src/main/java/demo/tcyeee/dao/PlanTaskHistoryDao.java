package demo.tcyeee.dao;

import demo.tcyeee.entity.po.PlanTaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenyueee
 * @since 2019-09-21 20:00
 */
@Repository
public interface PlanTaskHistoryDao extends JpaRepository<PlanTaskHistory, Integer> {
}
