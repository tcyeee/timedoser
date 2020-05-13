package demo.tcyeee.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenyueee
 * @since 2019/12/1 19:04
 */
@Mapper
public interface AclUserRoleMapper {

    List<Integer> findAllByBaseUser(String baseUser);

}
