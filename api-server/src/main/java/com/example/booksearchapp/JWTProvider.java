package com.example.booksearchapp;

import com.example.booksearchapp.entities.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTProvider {
    // Signatureのエンコードに使うシークレットキー
    private static final String TOKEN_SECRET_KEY = "This is secret!";

    // トークンの有効期間(1時間)
    private static final long TOKEN_VAILD_DURATION = 1000L * 60L * 60L;

    // ユーザ情報を取得するためのサービスクラス
    private final UserDetailsService service;

    public JWTProvider(UserDetailsService service) {
        this.service = service;
    }

//    public String createToken(LoginUser loginUser){
//        // Claimとしてユーザ名とロールを載せる
//        Claims claims = Jwts.claims().setSubject(loginUser.getUsername());
//        claims.put("roles", loginUser.getRoles());
//        // トークンの開始時間と満了時間を決める
//        Date iat = new Date();
//        Date exp = new Date(start.getTime() + TOKEN_VAILD_DURATION);
//        // JWTの作成
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(iat)
//                .setExpiration(exp)
//                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET_KEY)
//                .compact();
//    }
}
