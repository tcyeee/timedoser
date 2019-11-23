package demo.tcyeee.controller.message;

import com.alibaba.fastjson.JSON;
import demo.tcyeee.dao.SuggestMessageDao;
import demo.tcyeee.entity.po.SuggestMessage;
import demo.tcyeee.entity.vo.SuggestMessageVo;
import demo.tcyeee.service.SuggestMessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static demo.tcyeee.utils.ResponseUtils.*;
import static demo.tcyeee.utils.ResponseUtils.ReturnCode.PARAMS_ERROR;

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
        List<SuggestMessageVo> messageVo = suggestMessageService.findAll(currentPage, pageSize);
        long count = suggestMessageService.countAll();

        Map<String, Object> resultData = new HashMap<>();
        resultData.put("data", messageVo);
        resultData.put("count", count);
        return JSON.toJSONString(resultData);

    }


    /**
     * 添加一条留言
     *
     * @param message 添加的信息
     * @return data
     */
    @RequestMapping("addMessage")
    public String addMessage(String message) {
        if (StringUtils.isBlank(message)) return creatErrResponse(MESSAGE_ERROR_INFO);
        SuggestMessage addMessage = suggestMessageService.addMessage(message);
        return addMessage == null ? creatErrResponse() : creatJsonResponse(addMessage);
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
        return creatSuccessResponse();
    }
}

