package com.zzx;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class testGenJwt {
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

    String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
            .addClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
            .compact();

        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser().setSigningKey("aXRjYXN0")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoiaXRoZWltYSIsImV4cCI6MTc5MjM3Mjg4M30.ZfEYUVegOyK0jqrw0BwDh839hFpCfTRTyz0psVZcswg")
                .getBody();
        System.out.println(claims);
    }
}