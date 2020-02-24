package demo.tcyeee.service.impl;

import demo.tcyeee.dao.ProjectDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.Project;
import demo.tcyeee.entity.po.TomatoHistory;
import demo.tcyeee.mapper.TomatoHistoryMapper;
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

    @Resource
    private TomatoHistoryMapper tomatoHistoryMapper;

    @Override
    public boolean save(Project project) {
        Project save = projectDao.save(project);
        return save != null;
    }

    @Override
    public List<Project> findAll() {
        BaseUser userInfo = tokenUtils.getUserInfo();
        List<Project> result = projectDao.findAllByBaseUser(userInfo);

        // 1.找到最近一次项目,如果为空则选取最近的一个项目
        int lastProjectId;
        TomatoHistory history = tomatoHistoryMapper.getLastHistory(userInfo.getId());
        if (history == null) {
            lastProjectId = result.get(0).getId();
        } else {
            lastProjectId = history.getProject().getId();
        }

        // 2.标记最近一次项目
        for (Project project : result) {
            project.setLastProject(project.getId() == lastProjectId);
        }
        return result;
    }

    @Override
    public boolean deleteOne(Integer id) {
        projectDao.deleteById(id);
        return true;
    }
}
