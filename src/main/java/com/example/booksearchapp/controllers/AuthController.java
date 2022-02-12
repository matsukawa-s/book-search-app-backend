package com.example.booksearchapp.controllers;

import com.example.booksearchapp.forms.SignupForm;
import com.example.booksearchapp.services.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserDetailsServiceImpl userDetailsService;

    public AuthController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signup")
    public Integer signup(@RequestBody SignupForm signupForm){
        return userDetailsService.signup(signupForm);
    }
}
