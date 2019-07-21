package demo.tcyeee.dao;

import demo.tcyeee.entity.po.VersionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author chenyueee
 * @since 2019-07-21 12:29
 */
@Repository
public interface VersionDetailDao extends CrudRepository<VersionDetail, Long> {

    /**
     * 查看当前版本更新信息
     *
     * @param version verison
     * @return data
     */
    VersionDetail findByVersion(String version);

    /**
     * 查看其他版本信息
     *
     * @param version verison
     * @return data
     */
    List<VersionDetail> findAllByVersionIsNotOrderByIdDesc(String version);

}
