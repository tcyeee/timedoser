package demo.tcyeee.dao;

import demo.tcyeee.entity.po.AclUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyueee
 * @since 2019/12/1 18:43
 */
public interface AclUserRoleDao extends JpaRepository<AclUserRole, Integer> {
}
