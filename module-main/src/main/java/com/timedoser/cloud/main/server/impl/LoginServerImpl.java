package com.timedoser.cloud.main.server.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import com.timedoser.cloud.common.entity.FlxedData;
import com.timedoser.cloud.common.entity.base.BaseUserInfo;
import com.timedoser.cloud.common.entity.base.Result;
import com.timedoser.cloud.common.utils.TokenUtils;
import com.timedoser.cloud.main.common.entity.dto.UserPasswordDto;
import com.timedoser.cloud.main.common.entity.vo.UserPasswordVo;
import com.timedoser.cloud.main.mapper.AclUserMapper;
import com.timedoser.cloud.main.server.ILoginServer;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2020/6/18 16:17
 */
@Service
public class LoginServerImpl implements ILoginServer {

    @Resource
    private AclUserMapper aclUserMapper;

    /**
     * 通过账号密码登录
     *
     * @param param param登录参数
     * @return 账号信息
     */
    @Override
    public Result userPassword(UserPasswordDto param) {
        String basePassword = Base64.decodeStr(param.getPassword());
        String password = DigestUtils.md5DigestAsHex(basePassword.getBytes()).toUpperCase();
        UserPasswordVo result = aclUserMapper.userPassword(param.getPhoneNumber(), password);
        if (result != null && StringUtils.isNotBlank(result.getId())) {
            // 设置token
            BaseUserInfo baseUserInfo = new BaseUserInfo();
            BeanUtil.copyProperties(result, baseUserInfo);
            result.setToken(TokenUtils.generateToken(baseUserInfo));
            return Result.ok(result);
        }
        return Result.error(FlxedData.LOGIN_ERROR);
    }
}
