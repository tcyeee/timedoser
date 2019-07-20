package demo.tcyeee.service.impl;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.TokenDetail;
import demo.tcyeee.entity.base.WXCheck;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.LoginInfoVo;
import demo.tcyeee.service.BaseService;
import demo.tcyeee.service.LoginService;
import demo.tcyeee.utils.WeiXinUtils;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tcyeee
 * @since 2019-05-05 16:27
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private WeiXinUtils weiXinUtils;

    @Resource
    private BaseUserDao baseUserDao;

    @Resource
    private TokenUtils tokenUtils;

    @Value("${token.header}")
    private String tokenHeader;


    /**
     * 登录接口
     *
     * @param loginUser 账号密码
     * @param session   session
     * @return status
     */
    @Override
    public Map<String, String> login(BaseUser loginUser, HttpSession session) {
        Map<String, String> result = new HashMap<>();

        // 获取并加工返回
        BaseUser login = baseUserDao.findByMobilephoneAndPassword(loginUser.getMobilephone(), loginUser.getPassword());
        TokenDetail detail = new TokenDetail(login);
        result.put(tokenHeader, tokenUtils.generateToken(detail));
        return result;
    }

    @Override
    public LoginInfoVo getBaseInfo(String appCode, HttpSession session) {

        // 获取openid
        WXCheck openId = weiXinUtils.getOpenId(appCode);
        if (openId.getErrcode() != 0) {
            return null;
        }

        // 对比数据库有没有openid,如果有的话获取基础信息和token
        BaseUser baseUser = baseUserDao.findByOpenid(openId.getOpenid());
        if (baseUser == null) {
            // 添加一条记录
            BaseUser user = BaseUser.creatBaseUserForOpenId(openId.getOpenid());
            baseUserDao.save(user);
            return null;
        }

        // 如果数据库有openid,同时是注册用户, 则返回token和个人信息
        if (baseUser.getAccountType() == BaseUser.accountTypeEnum.two.getType()) {
            LoginInfoVo result = new LoginInfoVo();
            BeanUtils.copyProperties(baseUser, result);

            // @JsonIgnore 注解对封装返回值无效,所以这里手动删除password
            result.setPassword(null);

            result.setToken(login(baseUser, session).get(tokenHeader));
            return result;
        }
        return null;
    }


}
