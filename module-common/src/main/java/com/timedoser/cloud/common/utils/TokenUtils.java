package com.timedoser.cloud.common.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import com.timedoser.cloud.common.entity.base.BaseUserInfo;
import com.timedoser.cloud.common.entity.po.AclUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

/**
 * token 操作类
 * 1.暂时去除springScurity
 * 2.去除token过期时间校验
 * 3.校验主体为openId
 *
 * @author tcyeee
 */
@Component
public final class TokenUtils {

    private static final String SECRET = "MTIzNDU2";      // token盐
    private static final String TOKEN_HEADER = "token";   // 请求头中token的key
    private static final String SESSON_KEY = "baseInfo";  // session中存储userinfo的key
    private static final Long EXPIRATION = 604800L;       // token过期时间


    /**
     * 获取用户基础信息
     *
     * @return baseInfo
     */
    public static BaseUserInfo baseInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return (BaseUserInfo) request.getSession().getAttribute(TokenUtils.SESSON_KEY);
    }

    /**
     * 根据userInfo设置token
     */
    public String generateToken(BaseUserInfo user) {
        Object userStr = JSONUtil.toJsonStr(user);
        return Jwts.builder()
                .setClaims(MapUtil.builder("user", userStr).build())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(StandardCharsets.UTF_8))
                .compact();
    }


    /**
     * 获得当前时间
     */
    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }


    /**
     * 从 token 中拿到 userId
     */
    public String getIdFromToken(String token) {
        String userId;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            userId = claims.getId();
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }

    /**
     * 解析 token 的主体 Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 检查 token 是否处于有效期内
     */
    public Boolean validateToken(String token, AclUser baseUser) {
        final Date created = this.getCreatedDateFromToken(token);
        return (this.isTokenExpired(token))
                && (this.isCreatedBeforeLastPasswordReset(created, baseUser.getLastPasswordReset()));
    }

    /**
     * 获得我们封装在 token 中的 token 创建时间
     */
    private Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            created = new Date((Long) claims.get("created"));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
     * 获得我们封装在 token 中的 token 过期时间
     */
    private Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 检查当前时间是否在封装在 token 中的过期时间之后，若是，则判定为 token 过期
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        return this.generateCurrentDate().before(expiration);
    }

    /**
     * 检查 token 是否是在最后一次修改密码之前创建的（账号修改密码之后之前生成的 token 即使没过期也判断为无效）
     */
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.after(lastPasswordReset));
    }
}
