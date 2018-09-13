package com.helixz.oauth.demo.entity;

import com.helixz.oauth.demo.component.StaticApplicationContext;
import com.helixz.oauth.demo.config.ApplicationProperties;
import com.helixz.oauth.demo.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chamith
 */
@Getter
@Setter
@Entity
@Table(catalog = "oauth_demo", name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private UserStatus status;

    private Integer failedLoginAttemptCount;

    private LocalDateTime lastFailedLoginDate;

    private String name;

    @ManyToMany
    @JoinTable(catalog = "oauth_demo", name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        if (roles != null) {
            roles.forEach(role -> {
                if (role.getAuthorities() != null) {
                    authorities.addAll(role.getAuthorities());
                }
            });
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status != UserStatus.DELETED;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (status == UserStatus.ACTIVE) {
            return true;
        } else if (status == UserStatus.TEMP_LOCKED_BAD_CREDENTIALS && lastFailedLoginDate != null) {
            return lastFailedLoginDate.plusSeconds(StaticApplicationContext.getApplicationContext()
                    .getBean(ApplicationProperties.class).getAuth().getFailedLoginAttemptAccountLockTimeout())
                    .isBefore(LocalDateTime.now());
        } else {
            return false;
        }
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status != UserStatus.DELETED;
    }

    @Override
    public boolean isEnabled() {
        return !(status == UserStatus.INACTIVE || status == UserStatus.PENDING_ACTIVATION || status == UserStatus.CREATED);
    }
}
