package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.UserDetailsImpl;
import com.example.booksearchapp.forms.SignupForm;
import com.example.booksearchapp.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        var user = userMapper.findByUserName(email);

        return user
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    public Integer signup(SignupForm signupForm){
        signupForm.setPassword(bCryptPasswordEncoder.encode(signupForm.getPassword()));
        return userMapper.signup(signupForm);
    }
}