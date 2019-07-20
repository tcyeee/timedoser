package demo.tcyeee.service.impl;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.base.WXCheck;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.BaseInfoVo;
import demo.tcyeee.service.BaseService;
import demo.tcyeee.utils.TokenUtils;
import demo.tcyeee.utils.WeiXinUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;


/**
 * @author tcyeee
 * @since 2019-05-03 22:56
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Resource
    private WeiXinUtils weiXinUtils;

    @Resource
    private BaseUserDao userDao;


    /**
     * 获取用户唯一ID
     *
     * @param appCode 用户登录ID
     * @return openID
     */
    @Override
    public String getOpenId(String appCode) {
        WXCheck openId = weiXinUtils.getOpenId(appCode);
        return openId.getOpenid();
    }

    @Override
    public BaseInfoVo getuser() {
        return TokenUtils.userInfo();
    }

    /**
     * 通过appcode获到对应的UserInfo
     *
     * @param appCode appcode
     * @return userInfo
     */
    @Override
    public BaseInfoVo getBaseInfo(String appCode) {

        WXCheck wxCheck = weiXinUtils.getOpenId(appCode);
        if (StringUtils.isBlank(wxCheck.getOpenid())) {
            return null;
        }

        BaseInfoVo result = new BaseInfoVo();
        BaseUser user = userDao.findByOpenid(wxCheck.getOpenid());
        this.copy(result, user);

        return result;
    }


    /**
     * 通过手机号找到基础信息
     *
     * @param mobilephone 手机号
     * @return baseData
     */
    @Override
    public BaseInfoVo findByPhone(Integer mobilephone) {
        BaseInfoVo result = new BaseInfoVo();
        BaseUser user = userDao.findByMobilephone(mobilephone);

        this.copy(result, user);
        return result;
    }

    @Override
    public String test() {
        return "看到这个说明你成功了";
    }


    /* 参数复制 */
    private void copy(BaseInfoVo result, BaseUser user) {

        if (user != null) {
            BeanUtils.copyProperties(user, result);
        }
    }
}
