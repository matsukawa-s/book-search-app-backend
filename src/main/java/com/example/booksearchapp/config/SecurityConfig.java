package com.example.booksearchapp.config;

import com.example.booksearchapp.filters.JWTAuthenticationFilter;
import com.example.booksearchapp.filters.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.booksearchapp.SecurityConstants.LOGIN_URL;
import static com.example.booksearchapp.SecurityConstants.SIGNUP_URL;
import static com.example.booksearchapp.security.UserRoles.ROLE_ADMIN;
import static com.example.booksearchapp.security.UserRoles.ROLE_USER;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(SIGNUP_URL, LOGIN_URL).permitAll()
                .antMatchers("/books/**").hasAuthority(ROLE_USER.toString())
                .antMatchers("/admin/**").hasAuthority(ROLE_ADMIN.toString())
                .anyRequest().authenticated()
                .and().csrf().disable()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), bCryptPasswordEncoder()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}