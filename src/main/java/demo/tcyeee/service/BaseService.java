package demo.tcyeee.service;

import demo.tcyeee.entity.vo.BaseInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-05-03 22:55
 */
@Service
public interface BaseService {

    /**
     * 获取用户唯一ID
     *
     * @param appCode 用户登录ID
     * @return openID
     */
    String getOpenId(String appCode);

    /**
     * 测试接口
     *
     * @return data
     */
    BaseInfoVo getuser();

    /**
     * 通过appcode获到对应的UserInfo
     *
     * @param appCode appcode
     * @return userInfo
     */
    BaseInfoVo getBaseInfo(String appCode);

    /**
     * 通过手机号找到基础信息
     *
     * @param mobilephone 手机号
     * @return baseData
     */
    BaseInfoVo findByPhone(Integer mobilephone);

    /**
     * 测试接口
     *
     * @return none
     */
    String test();

}
