package demo.tcyeee.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenyueee
 * @since 2019/12/1 21:43
 */
@Mapper
public interface UserMapper {

    /**
     * 获取用户的角色
     *
     * @param userId userId
     * @return roles Str
     */
    String getRoles(@Param("userId") String userId);
}
