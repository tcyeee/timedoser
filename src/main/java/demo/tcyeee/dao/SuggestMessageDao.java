package demo.tcyeee.dao;

import demo.tcyeee.entity.po.SuggestMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tcyeee
 * @date 2019-07-22 11:27
 */
@Repository
public interface SuggestMessageDao extends CrudRepository<SuggestMessage, String> {

}
