package demo.tcyeee.dao;

import demo.tcyeee.entity.po.SuggestMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huxiong
 * @date 2019-07-22 11:27
 */
@Repository
public interface SuggestMessageDao extends CrudRepository<SuggestMessage, String> {

}
