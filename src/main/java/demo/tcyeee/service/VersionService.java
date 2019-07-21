package demo.tcyeee.service;

import demo.tcyeee.entity.vo.VersionInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author chenyueee
 * @since 2019-07-21 12:14
 */
@Service
public interface VersionService {

    /**
     * 查看版本更新信息
     *
     * @param verison 当前版本信息
     * @return version update detail
     */
    VersionInfoVo queryVersionUpdate(String verison);
}
