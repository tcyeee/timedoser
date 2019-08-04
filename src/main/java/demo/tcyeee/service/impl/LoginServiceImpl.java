package demo.tcyeee.service.impl;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.TokenDetail;
import demo.tcyeee.entity.base.WXCheck;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.LoginInfoVo;
import demo.tcyeee.entity.vo.WeixinUserInfoVo;
import demo.tcyeee.service.LoginService;
import demo.tcyeee.utils.TokenUtils;
import demo.tcyeee.utils.WeiXinUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
     * @return status
     */
    @Override
    public Map<String, String> login(BaseUser loginUser) {
        Map<String, String> result = new HashMap<>();

        // 获取并加工返回
        BaseUser login = baseUserDao.findByMobilephoneAndPassword(loginUser.getMobilephone(), loginUser.getPassword());
        TokenDetail detail = new TokenDetail(login);
        result.put(tokenHeader, tokenUtils.generateToken(detail));
        return result;
    }


    /**
     * 查看用户信息详情
     * 1.每次页面刷新都会调用这个方法
     * 2.如果有就返回,没有就新加一条数据
     *
     * @param appCode  微信临时用户id
     * @param userInfo 用户信息
     * @return data
     */
    @Override
    public LoginInfoVo getBaseInfo(String appCode, WeixinUserInfoVo userInfo) {
        LoginInfoVo result = new LoginInfoVo();

        // 获取openid
        WXCheck openId = weiXinUtils.getOpenId(appCode);
        if (openId.getErrcode() != 0) {
            return null;
        }

        // 对比数据库有没有openid,如果有的话获取基础信息和token , 没有就添加一条
        BaseUser baseUser = baseUserDao.findByOpenid(openId.getOpenid());
        if (baseUser == null) {
            BaseUser user = BaseUser.creatBaseUserForOpenId(openId.getOpenid(), userInfo);
            baseUser = baseUserDao.save(user);
        }

        BeanUtils.copyProperties(baseUser, result);
        result.setToken(tokenUtils.generateToken(new TokenDetail(baseUser)));
        return result;
    }
}
