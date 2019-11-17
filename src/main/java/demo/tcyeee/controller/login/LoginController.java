package demo.tcyeee.controller.login;

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

import static demo.tcyeee.entity.base.ReturnInfo.ReturnCode.PARAMS_ERROR;
import static demo.tcyeee.utils.ResponseUtils.*;

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
     * @return data
     */
    @PostMapping("login")
    public String login(BaseUser baseUser) {
        if (StringUtils.isBlank(baseUser.getMobilephone()) || baseUser.getPassword() == null) {
            return creatErrResponse(PARAMS_ERROR);
        }
        return creatJsonResponse(loginService.login(baseUser));
    }


    /**
     * [重要接口请勿修改]通过code获取所有基础信息
     * 注意: 使用小程序是无需登录的
     * <p>
     * 1.baseInfo {@link BaseInfoVo}
     *
     * @param appCode appCode
     * @return data
     */
    @RequestMapping("getBaseInfo")
    public String getBaseInfo(String appCode) {

        /* 数据校验:参数不可为空 */
        if (!CheckUtils.checkAppCode(appCode)) return creatErrResponse(PARAMS_ERROR);

        return creatJsonResponse(loginService.getBaseInfo(appCode));
    }

    // 用于测试
    @GetMapping("test")
    public String test() {
        return creatJsonResponse("看到这个代表你成功了!!!:githook3￿");
    }
}