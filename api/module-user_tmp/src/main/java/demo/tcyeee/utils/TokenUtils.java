package demo.tcyeee.utils;

import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.entity.po.BaseUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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


    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    @Value("${token.header}")
    private String tokenHeader;

    @Resource
    private HttpServletRequest request;

    @Resource
    private BaseUserDao baseUserDao;


    /**
     * 获取当前登录人信息
     *
     * @return userInfo
     */
    public BaseUser getUserInfo() {
        String tokenHeadere = request.getHeader(tokenHeader);
        String userId = this.getIdFromToken(tokenHeadere);
        if (userId == null) throw new NullPointerException("获取基础信息时token获取失败");
        return (baseUserDao.getOne(userId));
    }

    /**
     * 根据 TokenDetail 生成 Token
     * 这里openID的主键设置为openID
     */
    public String generateToken(BaseUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.ID, user.getId());
        claims.put(Claims.SUBJECT, user.getMobilephone());
        claims.put("created", new Date());

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
     * token 过期时间(秒)
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
    public Boolean validateToken(String token, BaseUser baseUser) {
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
