package com.timedoser.cloud.common.utils;

import java.util.Random;

/**
 * 自定义的一些基础类
 *
 * @author tcyeee
 * @since 2019-07-20 13:35
 */
@SuppressWarnings("all")
public final class BaseUtils {

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
