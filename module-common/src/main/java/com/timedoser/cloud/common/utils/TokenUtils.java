package com.timedoser.cloud.common.utils;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.timedoser.cloud.common.config.exception.MethodException;
import com.timedoser.cloud.common.entity.FlxedData;
import com.timedoser.cloud.common.entity.base.BaseUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * token 操作类
 * 1.暂时去除springScurity
 * 2.去除token过期时间校验
 * 3.校验主体为openId
 *
 * @author tcyeee
 */
@Slf4j
@Component
public final class TokenUtils {

    private static final String SECRET = "MTIzNDU2";      // token盐
    public static final String TOKEN_HEADER = "token";   // 请求头中token的key
    public static final String SESSON_KEY = "baseInfo";  // session中存储userinfo的key
    private static final Long EXPIRATION = 604800L;       // token过期时间


    /**
     * 获取用户基础信息
     *
     * @return baseInfo
     */
    public static BaseUserInfo baseInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String authToken = request.getHeader(TokenUtils.TOKEN_HEADER);
        return parseToken(authToken);
    }

    /**
     * 根据userInfo设置token
     */
    public static String generateToken(BaseUserInfo user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.ISSUER, JSONUtil.toJsonStr(user));         // userInfo
        claims.put(Claims.ISSUED_AT, System.currentTimeMillis());    // 创建时间

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))     // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(StandardCharsets.UTF_8)) // 设置签名
                .compact();
    }

    /**
     * 从token中解析出BaseUserInfo
     *
     * @param token token信息
     * @return user info
     */
    public static BaseUserInfo parseToken(String token) {
        if (StringUtils.isBlank(token)) return null;
        String jsonStr = getClaims(token).get(Claims.ISSUER).toString();
        return JSON.parseObject(jsonStr, BaseUserInfo.class);
    }


    /**
     * token检查
     * 1. 检查token是否过期
     * 2. 暂时还没想好
     */
    public static Boolean validateToken(String token) {
        Claims claims = getClaims(token);
        Date created = new Date((Long) claims.get(Claims.ISSUED_AT));

        // 1.检查token是否过期
        return new Date().after(created);
    }


    // 获取 Claims 信息
    private static Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new MethodException(FlxedData.TOKEN_ERROR);
        }
        return claims;
    }

}
