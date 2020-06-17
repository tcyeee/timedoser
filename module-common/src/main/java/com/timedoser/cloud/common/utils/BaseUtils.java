package com.timedoser.cloud.common.utils;

import com.timedoser.cloud.common.entity.po.AclUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * 自定义的一些基础类
 *
 * @author tcyeee
 * @since 2019-07-20 13:35
 */
@SuppressWarnings("all")
public final class BaseUtils {

    /**
     * 获取当前登录人信息
     *
     * @return userInfo
     */
    @SuppressWarnings("all")
    public static AclUser userInfo() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //已经拿到session,就可以拿到session中保存的用户信息了。
        Object userInfo = request.getSession().getAttribute("userInfo");
        return (AclUser) userInfo;
    }

    // 随机字符串生成
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";// 含有字符和数字的字符串
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


}
