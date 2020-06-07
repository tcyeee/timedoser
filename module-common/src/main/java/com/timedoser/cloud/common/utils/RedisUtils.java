package com.timedoser.cloud.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * 自带的stringRedisTemplate好看不好用,这里基于redisTemplate做了自定义封装
 *
 * @author tcyeee
 * @date 2019/11/22 21:02
 */
@SuppressWarnings("all")
public class RedisUtils {

    private RedisTemplate<String, Object> redisTemplate;
    private StringRedisTemplate stringRedisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    // ---------------------------- 一些通用的key ----------------------------
    public static final String loginInfo = "login_user_info_";     // 个人信息


    /**
     * 存值
     *
     * @param key   key
     * @param value value
     * @param time  失效时长(秒)
     */
    public void set(String key, Object value, long time) {
        if (value instanceof String && stringRedisTemplate != null) {
            stringRedisTemplate.opsForValue().set(key, (String) value);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
        if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 存值(默认一天后过期)
     *
     * @param k key
     * @param v value
     */
    public void set(String k, Object v) {
        set(k, v, 60 * 60 * 24);
    }

    /**
     * 判断是否有某条数据
     *
     * @param key key
     * @return boolean
     */
    public boolean contains(String key) {
        boolean hasKey = false;
        if (StringUtils.isNotBlank(key) && stringRedisTemplate != null) {
            hasKey = redisTemplate.hasKey(key);
        }
        return hasKey;
    }

    /**
     * 获取数据
     *
     * @param key key
     * @return data
     */
    public String get(String key) {
        if (stringRedisTemplate != null) {
            return stringRedisTemplate.opsForValue().get(key);
        } else {
            return (String) redisTemplate.opsForValue().get(key);
        }
    }

    /**
     * 获取数据
     *
     * @param key key
     * @return data
     */
    public <T> T getObject(String key) {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        return (T) valueOps.get(key);
    }

    /**
     * 移除数据
     *
     * @param key key
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 获取一个值的存货时间
     *
     * @param key key
     * @return long
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 所有的值
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
}