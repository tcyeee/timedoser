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

    /**
     * 查询所有的留言信息
     *
     * @param currentPage
     * @param pageSize    pageSize
     * @return data
     */
    @Query(value = "select a.*, b.username, b.avatar_url, b.account_type from time_doser.suggest_message a left join time_doser.base_user b on a.user_id = b.id limit 0,1", nativeQuery = true)
    List<Object[]> queryMessageVo(Integer currentPage, Integer pageSize);
}
