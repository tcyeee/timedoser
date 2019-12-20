package demo.tcyeee.mapper;

import demo.tcyeee.entity.vo.SuggestMessageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huxiong
 * @date 2019/12/20 15:16
 */
@Mapper
public interface SuggestMessageMapper {

    /**
     * 查看所有留言信息
     *
     * @return data
     */
    List<SuggestMessageVo> findAll();
}
