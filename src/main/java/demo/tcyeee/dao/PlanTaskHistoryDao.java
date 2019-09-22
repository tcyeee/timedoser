package demo.tcyeee.dao;

import demo.tcyeee.entity.po.PlanTaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenyueee
 * @since 2019-09-21 20:00
 */
@Repository
public interface PlanTaskHistoryDao extends JpaRepository<PlanTaskHistory, Integer> {

    @Query(nativeQuery = true, value =
            "select (select sum(tomato_work_time) " +
                    "        from time_doser.plan_task_history " +
                    "        where base_user_id = ?1 " +
                    "          and date(creat_time) = current_date)                                            as day, " +
                    "       (select sum(tomato_work_time) " +
                    "        from time_doser.plan_task_history " +
                    "        where base_user_id = ?1 " +
                    "          and date_format(creat_time, '%Y-%m') = date_format(current_timestamp, '%Y-%m')) as week, " +
                    "       sum(plan_task_id)                                                                  as allSum " +
                    "from time_doser.plan_task_history " +
                    "where base_user_id = ?1")
    List<Object[]> diyPageData(String id);
}
