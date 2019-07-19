package demo.tcyeee.service.impl;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.TokenDetail;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.service.LoginService;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
