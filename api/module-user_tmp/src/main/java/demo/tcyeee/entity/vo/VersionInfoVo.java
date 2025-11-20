package demo.tcyeee.entity.vo;

import demo.tcyeee.entity.po.VersionDetail;
import lombok.Data;

import java.util.List;

/**
 * 更新信息展示
 *
 * @author tcyeee
 * @since 2019-07-21 12:24
 */
@Data
public class VersionInfoVo {
    private VersionDetail thisVersion;
    List<VersionDetail> versionDetails;
}
