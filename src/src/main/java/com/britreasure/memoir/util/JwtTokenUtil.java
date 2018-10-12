package com.britreasure.memoir.util;

import com.google.common.base.Charsets;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Iterator;
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

    public String getUsernameFromToken(String token) {

        Map<String, Object> map = getClaimsFromToken(token);
        if (map != null) {
            if (map.containsKey("username")) {
                return map.get("username").toString();
            }
        }
        return null;

    }

    public boolean validateToken(String token, Object object) {

        Map<String, Object> oldmap = getClaimsFromToken(token);
        Map<String, Object> map = BeanToMapUtil.objectToMap(object);
        if (oldmap == null) {
            return false;
        }
        if (!oldmap.containsKey("exp")) {
            return false;
        }
        Long lastTokenDateLong = Long.parseLong(oldmap.get("exp").toString());
        Long nowDateLong = System.currentTimeMillis() / 1000;
        if (lastTokenDateLong - nowDateLong > EXPIRATION_TIME) {
            return false;
        }


        Iterator<Map.Entry<String, Object>> iter1 = oldmap.entrySet().iterator();
        while (iter1.hasNext()) {
            Map.Entry<String, Object> entry1 = iter1.next();
            if (entry1.getKey() != "exp") {
                Object m1value = null;
                if (entry1.getValue() != null) {
                    m1value = entry1.getValue();
                }
                Object m2value = null;
                if (map.get(entry1.getKey()) != null) {
                    m2value = map.get(entry1.getKey());
                }

                if (!m1value.equals(m2value)) {
                    return false;
                }
            }
        }
        return true;
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