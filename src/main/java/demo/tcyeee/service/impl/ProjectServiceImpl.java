package demo.tcyeee.service.impl;

import demo.tcyeee.dao.ProjectDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.Project;
import demo.tcyeee.service.ProjectService;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyueee
 * @since 2020/1/20 23:01
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;

    @Resource
    private TokenUtils tokenUtils;

    @Override
    public boolean save(Project project) {
        Project save = projectDao.save(project);
        return save != null;
    }

    @Override
    public List<Project> getAll() {
        BaseUser userInfo = tokenUtils.getUserInfo();
        return projectDao.findAllByBaseUserId(userInfo.getId());
    }

    @Override
    public boolean deleteOne(Integer id) {
        projectDao.deleteById(id);
        return true;
    }
}
