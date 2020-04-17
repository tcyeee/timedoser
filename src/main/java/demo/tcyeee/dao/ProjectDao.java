package demo.tcyeee.dao;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenyueee
 * @since 2020/1/20 23:10
 */
@Repository
public interface ProjectDao extends JpaRepository<Project, String> {

    /**
     * find all
     *
     * @param baseUser base user
     * @return all project
     */
    List<Project> findAllByBaseUser(BaseUser baseUser);
}
