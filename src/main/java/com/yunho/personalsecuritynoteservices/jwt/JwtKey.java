package com.yunho.personalsecuritynoteservices.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.data.util.Pair;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;
import java.util.Random;

public class JwtKey {

    private static final Map<String, String> SECRET_KEY_SET = Map.of(
            "key1", "SpringSecurityJWTPracticeProjectIsSoGoodAndThisProjectIsSoFunSpringSecurityJWTPracticeProjectIsSoGoodAndThisProjectIsSoFun",
            "key2", "GoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurity",
            "key3", "HelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurity"
    );
    private static final String[] KID_SET = SECRET_KEY_SET.keySet().toArray(new String[0]);
    private static Random randomIndex = new Random();

    public static Pair<String, String> getRandomKey() {
        String kid = KID_SET[randomIndex.nextInt(KID_SET.length)];
        return Pair.of(kid, SECRET_KEY_SET.get(kid));
    }

    public static Key getKey(String kid) {
        String key = SECRET_KEY_SET.getOrDefault(kid, null);
        if (key == null)
            return null;
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }
}
