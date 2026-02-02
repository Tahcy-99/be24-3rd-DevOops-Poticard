package com.poticard.api.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenMaker {

    public static String getUserToken(Integer userId, String userName){
        // 토큰에 사용되는 키, 절대로 공개하면 안됨
        String key=System.getenv("JWT_SECRET_KEY");
        SecretKey encodedKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));

        // 토큰을 생성하는 코드
        String jwt = Jwts.builder()
                .claim("userId", userId)
                .claim("userName", userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+300000))
                .signWith(encodedKey)
                .compact();
        return jwt;


    }
}
