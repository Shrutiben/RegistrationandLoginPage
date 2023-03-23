package com.registrationapp.registrationapp.Config;

import com.registrationapp.registrationapp.Model.UserDtls;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails {
    private UserDtls user;

    public CustomUserDetails(UserDtls user) {
        super();
        this.user = user;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(simpleGrantedAuthority);
    }


    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getEmail();
    }

    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }


    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
