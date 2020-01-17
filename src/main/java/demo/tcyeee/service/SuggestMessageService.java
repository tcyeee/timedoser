package demo.tcyeee.service;

import com.github.pagehelper.PageInfo;
import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.po.SuggestMessage;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @date 2019-07-22 11:26
 */
@Service
public interface SuggestMessageService {

    /**
     * 添加一条留言
     *
     * @param messageContents 添加的留言信息
     * @return data
     */
    SuggestMessage addMessage(String messageContents);

    /**
     * 查看所有留言信息
     *
     * @param pageBean pageBean
     * @return msg list
     */
    PageInfo<Object> findAll(PageBean pageBean);
}
