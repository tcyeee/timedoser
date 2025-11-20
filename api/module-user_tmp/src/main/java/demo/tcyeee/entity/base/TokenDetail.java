package demo.tcyeee.entity.base;

import demo.tcyeee.entity.po.BaseUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 1. 实现了 UserDetails 接口的模型类
 * 2. 拓展了 UserDetails 的属性
 * 3. 可以承载 创建 token 的日期，和 token 过期的日期
 * 4. 用于判断用户传来的 token 是否可用
 *
 * @author tcyeee
 * @since 2019-05-08 10:53
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class TokenDetail extends BaseUser implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    private Boolean enabled;

    // 定义 UserDetails 必要的属性，因为不打算启用这些限制条件，所以不对这些条件做限制，全部设置为 true （通过）
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;

    TokenDetail(String id, String username, String password, Date lastPasswordReset, Collection<? extends GrantedAuthority> authorities, Boolean enabled) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setLastPasswordReset(lastPasswordReset);
        this.setAuthorities(authorities);
        this.enabled = enabled;
    }


    public TokenDetail(BaseUser user) {
        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthoritiesString());
        } catch (Exception e) {
            authorities = null;
        }

        Date lastPasswordReset = new Date();
        lastPasswordReset.setTime(user.getLastPasswordReset() == null ? System.currentTimeMillis() : user.getLastPasswordReset().getTime());

        this.setId(user.getId());
        this.setMobilephone(user.getMobilephone());
        this.setPassword(user.getPassword());
        this.authorities = authorities;
        this.enabled = user.getEnable() == enableTypeEnum.defult;
        this.setLastPasswordReset(lastPasswordReset);
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
