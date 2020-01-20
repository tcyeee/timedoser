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

    List<Project> getAll();

    boolean deleteOne(Integer id);
}
