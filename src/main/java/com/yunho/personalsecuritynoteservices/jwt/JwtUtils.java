package com.yunho.personalsecuritynoteservices.jwt;

import com.yunho.personalsecuritynoteservices.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.util.Pair;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtils {

    public static String getUsername(String token) {
        return Jwts.parserBuilder() // parser용 builder
                .setSigningKeyResolver(SigningKeyResolver.instance)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        Date now = new Date(); // 현재 시간
        Pair<String, String> key = JwtKey.getRandomKey();

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setHeaderParam(JwsHeader.KEY_ID, key.getFirst())
                .setExpiration(new Date(now.getTime() + JwtProperties.EXPIRATION_TIME)) // 토큰 만료 시간 설정
                .signWith(Keys.hmacShaKeyFor(key.getSecond().getBytes(StandardCharsets.UTF_8))) // 알고리즘과 KEY
                .compact();
    }
}
