package com.example.booksearchapp.entities;

import com.example.booksearchapp.security.SecurityUtils;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {
    @Getter
    private LoginUser loginUser;

    public UserDetailsImpl(LoginUser loginUser) {
        super(loginUser.getEmail(), loginUser.getPassword(), SecurityUtils.getAuthority(loginUser.getAuthority()));
        this.loginUser = loginUser;
    }
}

