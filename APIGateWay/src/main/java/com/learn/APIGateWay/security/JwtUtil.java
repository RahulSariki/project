package com.learn.APIGateWay.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET =
            "stopnrestauthenticationjwtsecretkey2026version40";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public void validateToken(String token) {

        Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
        System.out.println("Called");
    }

    public Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
