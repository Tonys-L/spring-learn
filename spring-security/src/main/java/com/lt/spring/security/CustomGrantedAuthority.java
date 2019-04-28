package com.lt.spring.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_ADMIN";
    }
}
