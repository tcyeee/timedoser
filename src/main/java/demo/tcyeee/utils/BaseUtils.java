package demo.tcyeee.utils;

import java.util.UUID;

/**
 * 自定义的一些基础类
 *
 * @author chenyueee
 * @since 2019-07-20 13:35
 */
public final class BaseUtils {

    /**
     * 获取一个32位的UUID
     *
     * @return uuid
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
