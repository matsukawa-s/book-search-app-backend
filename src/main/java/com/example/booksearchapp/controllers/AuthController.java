package com.example.booksearchapp.controllers;

import com.example.booksearchapp.forms.SignupForm;
import com.example.booksearchapp.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("admin/auth/test")
    public ResponseEntity<String> authTest(@AuthenticationPrincipal String userId){
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var user = auth.getPrincipal();

        return ResponseEntity.ok(userId);
    }
}
