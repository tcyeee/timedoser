package demo.tcyeee.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehCache工具类
 * cacheName在ehcache.xml中配置
 *
 * @author huxiong
 * @date 2019-07-30 18:34
 */
@SuppressWarnings("unused")
public final class EhCacheUtils {

    private static CacheManager cacheManager = CacheManager.create();
    private static final String DEFULT_CACHE = "defultCache";
    private static final String FUNCTION_CACHE = "functionCache";

    // 用户登录时候存入的数据
    public static final String LOGIN_USER_INFO = "loginUserInfo";
    public static final String TOKEN_INFO = "TokenInfo";


    /**
     * 获取默认缓存
     *
     * @param key key
     * @return data
     */
    public static Object get(String key) {
        return get(DEFULT_CACHE, key);
    }

    /**
     * 写入默认缓存
     *
     * @param key key
     */
    public static void set(String key, Object value) {
        put(DEFULT_CACHE, key, value);
    }

    /**
     * 从默认缓存中移除
     *
     * @param key key
     */
    public static void remove(String key) {
        remove(DEFULT_CACHE, key);
    }


    /**
     * 获取缓存
     *
     * @param cacheName cacheName
     * @param key       key
     * @return data
     */
    public static Object get(String cacheName, String key) {
        Element element = getCache(cacheName).get(key);
        return element == null ? null : element.getObjectValue();
    }

    /**
     * 写入缓存
     *
     * @param cacheName cacheName
     * @param key       key
     * @param value     value
     */
    public static void put(String cacheName, String key, Object value) {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName cacheName
     * @param key       key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }

    /**
     * 获得一个Cache，没有则创建一个。
     *
     * @param cacheName cacheName
     * @return data
     */
    private static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }


}