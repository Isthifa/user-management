package com.isthifa.registration.security;

import com.isthifa.registration.entity.RegisterD;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomerConfig implements UserDetails {
    private RegisterD registerD;


    public CustomerConfig(RegisterD registerD) {
        this.registerD = registerD;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority sim=new SimpleGrantedAuthority(registerD.getRole());
        return Arrays.asList(sim);
    }

    @Override
    public String getPassword() {
        return registerD.getPassword();
    }

    @Override
    public String getUsername() {
        return registerD.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
