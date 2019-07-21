package demo.tcyeee.service.impl;

import demo.tcyeee.dao.VersionDetailDao;
import demo.tcyeee.entity.vo.VersionInfoVo;
import demo.tcyeee.service.VersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyueee
 * @since 2019-07-21 12:14
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Resource
    private VersionDetailDao versionDetailDao;


    /**
     * 查看版本更新信息
     *
     * @param verison 当前版本信息
     * @return version update detail
     */
    @Override
    public VersionInfoVo queryVersionUpdate(String verison) {
        VersionInfoVo result = new VersionInfoVo();
        result.setThisVersion(versionDetailDao.findByVersion(verison));
        result.setVersionDetails(versionDetailDao.findAllByVersionIsNotOrderByIdDesc(verison));
        return result;
    }
}
