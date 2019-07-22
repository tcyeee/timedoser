package demo.tcyeee.controller;

import demo.tcyeee.dao.SuggestMessageDao;
import demo.tcyeee.entity.base.PageBean;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import demo.tcyeee.service.SuggestMessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static demo.tcyeee.entity.enums.base.ReturnCodeList.MESSAGE_ERROR_INFO;
import static demo.tcyeee.entity.enums.base.ReturnCodeList.PARAMS_ERROR_INFO;
import static demo.tcyeee.entity.enums.base.ReturnCodeList.ReturnCode.PARAMS_ERROR;
import static demo.tcyeee.entity.enums.base.ReturnCodeList.ReturnCode.SUCCESS;
import static demo.tcyeee.utils.ResponseUtils.creatErrResponse;
import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;

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
    public String queryAllMessage(PageBean pageBean) {
        SuggestMessageVo messageVo = suggestMessageService.findAll(currentPage, pageSize);
        long count = suggestMessageService.countAll();
        return creatJsonResponse(messageVo,count);
    }


    /**
     * 添加一条留言
     *
     * @param message 添加的信息
     * @return data
     */
    @RequestMapping("addMessage")
    public String addMessage(SuggestMessage message) {
        if (message == null || StringUtils.isBlank(message.getContext())) {
            return creatErrResponse(PARAMS_ERROR, MESSAGE_ERROR_INFO);
        }
        return creatJsonResponse(suggestMessageService.addMessage(message));
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

