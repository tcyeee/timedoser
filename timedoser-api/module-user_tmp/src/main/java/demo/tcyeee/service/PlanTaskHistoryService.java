package demo.tcyeee.service;

import org.springframework.stereotype.Service;

/**
 * @author chenyueee
 * @since 2019-09-01 21:30
 */
@Service
public interface PlanTaskHistoryService {

    /**
     * 完成一条任务
     *
     * @return data
     */
    String addOne(Integer planTaskId);

    /**
     * 查看所有
     *
     * @return data
     */
    String findAll();

    /**
     * 删除一条
     *
     * @return data
     */
    String deleteOne(Integer planTaskId);
}
