package demo.tcyeee.controller;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.BaseInfoVo;
import demo.tcyeee.service.BaseService;
import demo.tcyeee.service.LoginService;
import demo.tcyeee.utils.CheckUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static demo.tcyeee.entity.enums.base.ReturnCodeList.PARAMS_ERROR_INFO;
import static demo.tcyeee.entity.enums.base.ReturnCodeList.ReturnCode.PARAMS_ERROR;
import static demo.tcyeee.utils.ResponseUtils.creatErrResponse;
import static demo.tcyeee.utils.ResponseUtils.creatJsonResponse;

/**
 * @author tcyeee
 * @since 2019-05-03 22:32
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private BaseService baseService;

    @Resource
    private LoginService loginService;

    @Value("${token.header}")
    private String tokenHeader;


    /**
     * 通过小程序登录code获取openID
     * 1.登录ID,五分钟刷新,查询一次失效
     *
     * @param appCode 用户登录ID
     * @return openId
     */
    @GetMapping("getOpenId")
    public String getOpenId(String appCode) {
        if (StringUtils.isBlank(appCode)) {
            return creatErrResponse(PARAMS_ERROR);
        }
        return creatJsonResponse(baseService.getOpenId(appCode));
    }


    /**
     * 账户登录接口
     *
     * @param baseUser 手机号和密码
     * @param session  session
     * @return data
     */
    @PostMapping("login")
    public String login(BaseUser baseUser, HttpSession session) {
        if (baseUser.getMobilephone() == null || baseUser.getMobilephone() == 0 || baseUser.getPassword() == null) {
            return creatErrResponse(PARAMS_ERROR);
        }
        return creatJsonResponse(loginService.login(baseUser, session));
    }


    /**
     * [重要接口请勿修改]通过code获取所有基础信息
     * 注意: 使用小程序是无需登录的
     * <p>
     * 1.baseInfo {@link BaseInfoVo}
     * 2.token {@link demo.tcyeee.config.filter.AuthenticationTokenFilter}
     *
     * @param appCode appCode
     * @return data
     */
    @GetMapping("getBaseInfo")
    public String getBaseInfo(String appCode, HttpSession session) {

        /* 数据校验:参数不可为空 */
        if (!CheckUtils.checkAppCode(appCode)) {
            return creatErrResponse(PARAMS_ERROR);
        }
        return creatJsonResponse(loginService.getBaseInfo(appCode, session));
    }

    // 用于测试
    @RequestMapping("test")
    public String test(String test) {
        if (StringUtils.isBlank(test)) return creatErrResponse(PARAMS_ERROR, PARAMS_ERROR_INFO + "test");

        return creatJsonResponse("看到这个说明你连接成功了" + test);
    }

}