package demo.tcyeee.service.impl;

import demo.tcyeee.dao.SuggestMessageDao;
import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import demo.tcyeee.service.SuggestMessageService;
import demo.tcyeee.utils.BaseUtils;
import demo.tcyeee.utils.EntityUtils;
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

    /**
     * 添加一条留言
     *
     * @param message 添加的留言信息
     * @return data
     */
    @Override
    public SuggestMessage addMessage(SuggestMessage message) {
        message.setId(BaseUtils.getUuid());
        return suggestMessageDao.save(message);
    }


    /**
     * 查看所有留言信息
     *
     * @return data
     */
    @Override
    public List<SuggestMessageVo> findAll(PageBean pageBean) {
        List<Object[]> objects = suggestMessageDao.queryMessageVo(pageBean.getCurrentPage(), pageBean.getPageSize());
        return EntityUtils.castEntity(objects, SuggestMessageVo.class);
    }

    @Override
    public long countAll() {
        return suggestMessageDao.count();
    }
}
