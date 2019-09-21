package demo.tcyeee.utils;

import demo.tcyeee.entity.po.BaseUser;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

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
    public static BaseUser userInfo() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //已经拿到session,就可以拿到session中保存的用户信息了。
        Object userInfo = request.getSession().getAttribute("userInfo");
        return userInfo == null ? null : (BaseUser) userInfo;
    }

    /**
     * 获取一个32位的UUID
     *
     * @return uuid
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 生成signature
    public static String getSignature() {
        String randomString = getRandomString(15);
        return DigestUtils.md5DigestAsHex(randomString.getBytes()).toUpperCase();
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


    // 获取字符编码
    public static String getEncoding(String str) {
        try {
            String[] encodeList = {"GB2312", "ISO-8859-1", "UTF-8", "GBK"};
            for (String code : encodeList) {
                if (str.equals(new String(str.getBytes(code), code))) {
                    return code;
                }
            }
        } catch (Exception ignored) {
        }
        return ""; //如果都不是，说明输入的内容不属于常见的编码格式。
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuilder unicode = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u").append(Integer.toHexString(c));
        }

        return unicode.toString();
    }

    // 获取ip地址
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
}
