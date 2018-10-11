package com.britreasure.memoir.util;

import com.google.common.base.Charsets;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午2:28
 */
@Component
public class JwtTokenUtil {


    @Value("${jwt.secret}")
    private String secret;

    private long EXPIRATION_TIME = 3600000;

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    }

    public SecretKey generalKey() {
        //秘钥长度大于64位
        byte[] tmpByte = secret.getBytes(Charsets.UTF_8);
        SecretKey key = Keys.hmacShaKeyFor(tmpByte);
        return key;
    }


    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(generalKey())
                .compact();
    }

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(generalKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}