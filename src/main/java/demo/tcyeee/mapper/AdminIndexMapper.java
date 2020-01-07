package demo.tcyeee.mapper;

import demo.tcyeee.entity.vo.AdminIndexCountVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huxiong
 * @date 2020/1/7 17:00
 */
@Mapper
public interface AdminIndexMapper {

    AdminIndexCountVo getCount();
}
