package com.company.config;

import com.company.entity.ProfileEntity;
import com.company.enums.ProfileStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetail implements UserDetails {
    private ProfileEntity profileEntity;

    public CustomUserDetail(ProfileEntity profile) {
        this.profileEntity = profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singleton(new SimpleGrantedAuthority(profileEntity.getRole().name()));
    }

    @Override
    public String getPassword() {
        return profileEntity.getPswd();
    }

    @Override
    public String getUsername() {
        return profileEntity.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (profileEntity.getStatus().equals(ProfileStatus.ACTIVE)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
