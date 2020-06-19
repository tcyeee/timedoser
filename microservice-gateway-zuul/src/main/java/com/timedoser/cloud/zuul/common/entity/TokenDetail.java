package com.timedoser.cloud.zuul.common.entity;

import com.timedoser.cloud.common.entity.base.BaseUserInfo;
import com.timedoser.cloud.common.entity.po.AclUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 1. 实现了 UserDetails 接口的模型类
 * 2. 拓展了 UserDetails 的属性
 * 3. 可以承载 创建 token 的日期，和 token 过期的日期
 * 4. 用于判断用户传来的 token 是否可用
 *
 * @author tcyeee
 * @since 2019-05-08 10:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TokenDetail extends BaseUserInfo implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    // 定义 UserDetails 必要的属性，因为不打算启用这些限制条件，所以不对这些条件做限制，全部设置为 true （通过）
    private Boolean enabled;
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private String username;
    private String password;


    public TokenDetail(BaseUserInfo user) {
        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthoritiesString());
        } catch (Exception e) {
            authorities = null;
        }

        this.setId(user.getId());
        this.setMobilephone(user.getMobilephone());
        this.authorities = authorities;
        this.enabled = user.getEnable() == AclUser.enableTypeEnum.defult.getIndex();
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
