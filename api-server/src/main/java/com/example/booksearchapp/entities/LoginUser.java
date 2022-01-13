package com.example.booksearchapp.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LoginUser extends org.springframework.security.core.userdetails.User {
    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
