package com.example.booksearchapp.filters;

import com.example.booksearchapp.entities.UserDetailsImpl;
import com.example.booksearchapp.forms.UserLoginForm;
import com.example.booksearchapp.security.SecurityUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static com.example.booksearchapp.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        setUsernameParameter(LOGIN_ID);
        setPasswordParameter(PASSWORD);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            // requestパラメータからユーザ情報を読み取る
            UserLoginForm userLoginForm = new ObjectMapper().readValue(request.getInputStream(), UserLoginForm.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginForm.getEmail(),
                            userLoginForm.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // 認証に成功した場合の処理
    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {
        var user = (UserDetailsImpl)auth.getPrincipal();
        var mapper = new ObjectMapper();
        var claims = new HashMap<String, Object>(){
            {
                put("sub", user.getLoginUser().getId());
                put("role", user.getLoginUser().getAuthority());
            }
        };

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getLoginUser().getId().toString())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)))
                .compact();

        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.addHeader("Access-Control-Expose-Headers", HEADER_STRING);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        var body = new HashMap<String, Object>(){
            {
                put("firstName", user.getLoginUser().getFirstName());
                put("lastName", user.getLoginUser().getLastName());
                put("isAdmin", SecurityUtils.getIsAdmin(user.getLoginUser().getAuthority()));
            }
        };

        try {
            var json = mapper.writeValueAsString(body);
            res.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}