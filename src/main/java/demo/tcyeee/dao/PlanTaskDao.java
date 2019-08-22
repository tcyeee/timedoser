package demo.tcyeee.dao;

import demo.tcyeee.entity.po.BaseUser;
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
     * @param baseUser baseUser
     * @param type   type
     * @return data
     */
    List<PlanTask> findAllByBaseUserAndTypeOrderByCreatedateDesc(BaseUser baseUser, int type);

    /**
     * 统计用户创建的任务数量
     *
     * @param baseUser baseUser
     * @return count
     */
    int countByBaseUser(BaseUser baseUser);

    /**
     * 统计
     *
     * @param baseUser baseUser
     * @param type   type
     * @return count
     */
    int countByBaseUserAndType(BaseUser baseUser, int type);

    /**
     * 修改任务状态
     * 1. 如果是把任务状态修改为1(默认),则同时修改创建时间
     *
     * @param taskId taskId
     * @param type   {@link PlanTask.typeEnum}
     * @return status
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE time_doser.plan_task SET type = ?2, createdate = if(?2=1,current_timestamp,createdate) WHERE id = ?1", nativeQuery = true)
    int diyUpdataTask(String taskId, int type);
}
