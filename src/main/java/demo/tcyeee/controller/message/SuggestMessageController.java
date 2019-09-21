package demo.tcyeee.controller.message;

import demo.tcyeee.dao.SuggestMessageDao;
import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import demo.tcyeee.service.SuggestMessageService;
import demo.tcyeee.utils.PageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static demo.tcyeee.entity.base.ReturnInfo.ReturnCode.*;
import static demo.tcyeee.utils.ResponseUtils.*;

/**
 * @author huxiong
 * @date 2019-07-22 10:55
 */
@RestController
@RequestMapping("message")
public class SuggestMessageController {

    @Resource
    private SuggestMessageDao suggestMessageDao;

    @Resource
    private SuggestMessageService suggestMessageService;

    /**
     * 查看所有留言
     *
     * @return data
     */
    @RequestMapping("queryAllMessage")
    public String queryAllMessage(Integer currentPage, Integer pageSize) {
        PageBean pageBean = PageUtils.getPageBean(currentPage, pageSize);

        List<SuggestMessageVo> messageVo = suggestMessageService.findAll(pageBean);
        long count = suggestMessageService.countAll();
        return creatJsonResponse(messageVo, count);
    }


    /**
     * 添加一条留言
     *
     * @param message 添加的信息
     * @return data
     */
    @RequestMapping("addMessage")
    public String addMessage(String message) {
        if (StringUtils.isBlank(message)) return creatErrResponse(PARAMS_ERROR, MESSAGE_ERROR_INFO);
        SuggestMessage addMessage = suggestMessageService.addMessage(message);
        return addMessage == null ? creatErrResponse(SYSTEM_ERROR) : creatJsonResponse(addMessage);
    }


    /**
     * 删除一条留言
     *
     * @param id 留言id
     * @return status
     */
    @RequestMapping("deleteMessage")
    public String deleteMessage(String id) {
        if (StringUtils.isBlank(id)) return creatErrResponse(PARAMS_ERROR, PARAMS_ERROR_INFO + "id");

        suggestMessageDao.deleteById(id);
        return creatJsonResponse(SUCCESS);
    }
}

