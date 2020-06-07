//package com.timedoser.cloud.zuul.common.utils;
//
//import com.timedoser.cloud.common.entity.po.AclUser;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * token 操作类
// * 1.暂时去除springScurity
// * 2.去除token过期时间校验
// * 3.校验主体为openId
// *
// * @author tcyeee
// */
//@Component
//public final class TokenUtils {
//
//    // 签证
//    final static String secret = "SC+qWp(T'W6-2~V";
//    // 过期时间为15天
//    final static Long expiration = (long) (60 * 60 * 24 * 15);
//
//
//    /**
//     * 1.根据 TokenDetail 生成 Token
//     * 2.将userInfo存进redis
//     */
//    public String generateToken(AclUser user) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("userId", user.getId());
//        return Jwts.builder()
//                .setClaims(claims)
//                // 设置过期时间
//                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
//                // 设置验证
//                .signWith(SignatureAlgorithm.HS512, secret.getBytes(StandardCharsets.UTF_8))
//                .compact();
//    }
//
//
//    /**
//     * 获得当前时间
//     */
//    private Date generateCurrentDate() {
//        return new Date(System.currentTimeMillis());
//    }
//
//
//    /**
//     * 从 token 中拿到 userId
//     */
//    public String getIdFromToken(String token) {
//        String userId;
//        try {
//            final Claims claims = this.getClaimsFromToken(token);
//            userId = claims.getId();
//        } catch (Exception e) {
//            userId = null;
//        }
//        return userId;
//    }
//
//    /**
//     * 解析 token 的主体 Claims
//     */
//    private Claims getClaimsFromToken(String token) {
//        Claims claims;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            claims = null;
//        }
//        return claims;
//    }
//
//    /**
//     * 检查 token 是否处于有效期内
//     */
//    public Boolean validateToken(String token, AclUser baseUser) {
//        final Date created = this.getCreatedDateFromToken(token);
//        return (this.isTokenExpired(token))
//                && (this.isCreatedBeforeLastPasswordReset(created, baseUser.getLastPasswordReset()));
//    }
//
//    /**
//     * 获得我们封装在 token 中的 token 创建时间
//     */
//    private Date getCreatedDateFromToken(String token) {
//        Date created;
//        try {
//            final Claims claims = this.getClaimsFromToken(token);
//            created = new Date((Long) claims.get("created"));
//        } catch (Exception e) {
//            created = null;
//        }
//        return created;
//    }
//
//    /**
//     * 获得我们封装在 token 中的 token 过期时间
//     */
//    private Date getExpirationDateFromToken(String token) {
//        Date expiration;
//        try {
//            final Claims claims = this.getClaimsFromToken(token);
//            expiration = claims.getExpiration();
//        } catch (Exception e) {
//            expiration = null;
//        }
//        return expiration;
//    }
//
//    /**
//     * 检查当前时间是否在封装在 token 中的过期时间之后，若是，则判定为 token 过期
//     */
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = this.getExpirationDateFromToken(token);
//        return this.generateCurrentDate().before(expiration);
//    }
//
//    /**
//     * 检查 token 是否是在最后一次修改密码之前创建的（账号修改密码之后之前生成的 token 即使没过期也判断为无效）
//     */
//    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
//        return (lastPasswordReset != null && created.after(lastPasswordReset));
//    }
//}
