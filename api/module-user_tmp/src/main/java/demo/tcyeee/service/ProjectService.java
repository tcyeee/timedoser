package demo.tcyeee.service;

import demo.tcyeee.entity.po.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyueee
 * @since 2020/1/20 23:01
 */
@Service
public interface ProjectService {

    boolean save(Project project);

    /**
     * 查看所有的项目,同时标记处最近一次使用的项目
     *
     * @return data
     */
    List<Project> findAll();

    boolean deleteOne(String id);
}
