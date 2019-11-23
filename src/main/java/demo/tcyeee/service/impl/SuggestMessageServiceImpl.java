package demo.tcyeee.service.impl;

import demo.tcyeee.dao.SuggestMessageDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import demo.tcyeee.service.SuggestMessageService;
import demo.tcyeee.utils.BaseUtils;
import demo.tcyeee.utils.EntityUtils;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huxiong
 * @date 2019-07-22 11:26
 */
@Service
public class SuggestMessageServiceImpl implements SuggestMessageService {

    @Resource
    private SuggestMessageDao suggestMessageDao;

    @Resource
    private TokenUtils tokenUtils;

    /**
     * 添加一条留言
     *
     * @param messageContents 添加的留言信息
     * @return data
     */
    @Override
    public SuggestMessage addMessage(String messageContents) {
        BaseUser userInfo = tokenUtils.getUserInfo();
        SuggestMessage message = new SuggestMessage();
        message.setId(BaseUtils.getUuid());
        message.setContext(messageContents);
        message.setBaseUser(userInfo);
        return suggestMessageDao.save(message);
    }


    /**
     * 查看所有留言信息
     *
     * @return data
     */
    @Override
    public List<SuggestMessageVo> findAll(Integer currentPage, Integer pageSize) {
        List<Object[]> objects = suggestMessageDao.queryMessageVo(currentPage, pageSize);
        return EntityUtils.castEntity(objects, SuggestMessageVo.class);
    }

    @Override
    public long countAll() {
        return suggestMessageDao.count();
    }
}
