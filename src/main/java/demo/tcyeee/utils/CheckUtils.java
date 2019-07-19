package demo.tcyeee.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验身份证、电话号码、邮箱地址是否合法
 *
 * @author tcyeee
 * @since 2019-04-29
 */
@SuppressWarnings("unused")
public final class CheckUtils {

    private final static String E_MAIL_CHECK = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private final static String PHONE_UNMBER_CHECK = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /* 校验提示类 */
    public static final String NULL_POINTE = "请检查参数是否存在";

    /**
     * 通过正则条件检查字符串是否合法
     *
     * @param rule 匹配规则(正则表达式)
     * @param str  需要检查的字符串
     * @return true: 合法 false : 不合法
     */
    private static boolean isTrue(String rule, String str) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile(rule);
            Matcher matcher = regex.matcher(str);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 验证邮箱地址是否正确
     *
     * @param email email
     * @return boolean （合法：true，不合法：false）
     */
    public static boolean checkEmail(String email) {
        return isTrue(E_MAIL_CHECK, email);
    }


    /**
     * 验证手机号码是否合法
     *
     * @param mobiles mobiles
     * @return boolean （合法：true，不合法：false）
     */
    public static boolean isMobileNO(String mobiles) {
        return isTrue(PHONE_UNMBER_CHECK, mobiles);
    }
}
