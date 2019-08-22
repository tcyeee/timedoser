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
     * @param start    start
     * @param pageSize pageSize
     * @return data
     */
    @Query(nativeQuery = true, value =
            " select a.id as messageId, a.context, a.createdate, b.id, b.username, b.avatar_url, b.account_type " +
                    " from time_doser.suggest_message a " +
                    "         left join time_doser.base_user b on a.base_user_id = b.id " +
                    " order by a.createdate desc " +
                    " limit ?1,?2")
    List<Object[]> queryMessageVo(Integer start, Integer pageSize);
}
