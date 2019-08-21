package demo.tcyeee.dao;

import demo.tcyeee.entity.po.PlanTask;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author chenyueee
 * @since 2019-07-20 19:17
 */
@Repository
public interface PlanTaskDao extends CrudRepository<PlanTask, Integer> {

    /**
     * 获取用户创建的所有未删除的任务
     *
     * @param userId userId
     * @param type   不等于9 / 没有被删除
     * @return data
     */
    List<PlanTask> findAllByUserIdAndTypeIsNotOrderByCreatedateAsc(String userId, int type);

    /**
     * 统计用户创建的任务数量
     *
     * @param userId userId
     * @return count
     */
    int countByUserId(String userId);


    /**
     * 假删除一条任务数据
     *
     * @param taskId taskId
     * @return status
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE time_doser.plan_task SET type = 9 WHERE id = ?1 ")
    int diyDeleteOne(String taskId);
}
