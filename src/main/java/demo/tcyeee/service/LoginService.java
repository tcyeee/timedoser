package demo.tcyeee.service;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.LoginInfoVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author tcyeee
 * @since 2019-05-05 16:27
 */
@Service
public interface LoginService {

    /**
     * 登录接口
     *
     * @param loginUser 账号密码
     * @param session   session
     * @return status
     */
    Map<String, String> login(BaseUser loginUser, HttpSession session);

    LoginInfoVo getBaseInfo(String appCode, HttpSession session);
}
