package demo.tcyeee.dao;

import demo.tcyeee.entity.po.AclRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenyueee
 * @since 2019/12/1 18:42
 */
@Repository
public interface AclRoleDao extends JpaRepository<AclRole, Integer> {
}
