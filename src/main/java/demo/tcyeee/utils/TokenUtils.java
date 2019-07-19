package demo.tcyeee.utils;

import demo.tcyeee.entity.base.TokenDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token 操作类
 *
 * @author tcyeee
 */
@Component
public class TokenUtils {


    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    /**
     * 根据 TokenDetail 生成 Token
     */
    public String generateToken(TokenDetail tokenDetail) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", tokenDetail.getMobilephone());
        claims.put("created", this.generateCurrentDate());
        return this.generateToken(claims);
    }


    /**
     * 根据 claims 生成 Token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    /**
     * token 过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + this.expiration * 1000);
    }

    /**
     * 获得当前时间
     */
    private Date generateCurrentDate() {
        return new Date(System.currentTimeMillis());
    }


    /**
     * 从 token 中拿到 mobilephone
     */
    public Integer getMobilephoneFromToken(String token) {
        Integer mobilephone;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            mobilephone = Integer.valueOf(claims.getSubject());
        } catch (Exception e) {
            mobilephone = null;
        }
        return mobilephone;
    }


    /**
     * 解析 token 的主体 Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret.getBytes(StandardCharsets.UTF_8))
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
    public Boolean validateToken(String token, UserDetails userDetails) {
        TokenDetail user = (TokenDetail) userDetails;
        final Integer mobilephone = this.getMobilephoneFromToken(token);
        final Date created = this.getCreatedDateFromToken(token);
        return (mobilephone.equals(user.getMobilephone()) && (this.isTokenExpired(token)) && (this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
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
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
}
