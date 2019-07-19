package demo.tcyeee.controller;

import demo.tcyeee.entity.base.FixedData;
import demo.tcyeee.entity.enums.base.ReturnCode;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.BaseInfoVo;
import demo.tcyeee.entity.vo.LoginInfoVo;
import demo.tcyeee.service.BaseService;
import demo.tcyeee.service.LoginService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static demo.tcyeee.utils.BaseUtils.creatErrResponse;
import static demo.tcyeee.utils.BaseUtils.creatJsonResponse;

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
            return creatErrResponse(ReturnCode.PARAMS_ERROR);
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
            return creatErrResponse(ReturnCode.PARAMS_ERROR);
        }
        return creatJsonResponse(loginService.login(baseUser, session));
    }


    /**
     * [重要接口请勿修改]通过code获取所有基础信息
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
        if (StringUtils.isBlank(appCode)) {
            return creatErrResponse(ReturnCode.PARAMS_ERROR);
        }

        LoginInfoVo resut = new LoginInfoVo();
        BaseInfoVo baseInfo = baseService.getBaseInfo(appCode);
        Map<String, String> login = loginService.login(new BaseUser().creatBaseUser(baseInfo), session);

        /* 数据校验:登录信息不可为空的 */
        if (login == null || login.get(tokenHeader) == null) {
            return creatErrResponse(ReturnCode.SYSTEM_ERROR, FixedData.LOGIN_EXCEPTION);
        }

        // @JsonIgnore 注解对封装返回值无效,所以这里手动删除password
        baseInfo.setPassword(null);

        resut.setBaseInfoVo(baseInfo);
        resut.setToken(login.get(tokenHeader));

        return creatJsonResponse(resut);
    }

    // 用于测试
    @RequestMapping("test")
    public String test() {
        return creatJsonResponse("看到这个说明你连接成功了");
    }

}