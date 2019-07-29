package demo.tcyeee.service;

import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxiong
 * @date 2019-07-22 11:26
 */
@Service
public interface SuggestMessageService {

    /**
     * 添加一条留言
     *
     * @param messageContents 添加的留言信息
     * @param userId
     * @return data
     */
    SuggestMessage addMessage(String messageContents, String userId);

    /**
     * 查看所有留言信息
     *
     * @return data
     */
    List<SuggestMessageVo> findAll(PageBean pageBean);

    /**
     * 统计所有留言条数
     *
     * @return count
     */
    long countAll();
}
