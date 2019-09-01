package demo.tcyeee.service.impl;

import com.alibaba.fastjson.JSON;
import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.vo.WeixinUserInfoVo;
import demo.tcyeee.service.UserService;
import demo.tcyeee.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private BaseUserDao userDao;

    @Resource
    private TokenUtils tokenUtils;

    @Override
    public void updataUserInfo(String userinfo) {
        BaseUser userInfo = tokenUtils.getUserInfo();
        WeixinUserInfoVo weixinUserInfoVo = JSON.parseObject(userinfo, WeixinUserInfoVo.class);
        BeanUtils.copyProperties(weixinUserInfoVo, userInfo);
        userInfo.setUsername(weixinUserInfoVo.getNickName());
        userDao.save(userInfo);
    }
}
