package demo.tcyeee.service;

import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.LoginInfoVo;
import org.springframework.stereotype.Service;

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
     * @return status
     */
    Map<String, String> login(BaseUser loginUser);

    /**
     * 查看用户信息详情
     * 1.每次页面刷新都会调用这个方法
     * 2.如果有就返回,没有就新加一条数据
     *
     * @param appCode 微信临时用户id
     * @return data
     */
    LoginInfoVo getBaseInfo(String appCode);
}
