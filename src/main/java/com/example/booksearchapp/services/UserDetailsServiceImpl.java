package com.example.booksearchapp.services;

import com.example.booksearchapp.forms.SignupForm;
import com.example.booksearchapp.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;

    public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper userMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(@RequestBody String email) throws UsernameNotFoundException {
        // ユーザー検索
        var user = userMapper.findByUserName(email);
        System.out.println(user);
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    public Integer signup(SignupForm signupForm){
        // ハッシュ化
        signupForm.setPassword(bCryptPasswordEncoder.encode(signupForm.getPassword()));
        return userMapper.signup(signupForm);
    }
}