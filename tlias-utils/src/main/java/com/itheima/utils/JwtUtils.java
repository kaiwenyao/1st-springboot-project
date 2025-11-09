package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * 简单版 JWT 工具类（JJWT 0.9.x 写法）
 * 只有两个方法：生成令牌、解析令牌
 */
public class JwtUtils {

    /**
     * 与原测试一致的密钥（"itheima" 的 Base64 字符串）
     */
    private static final String SECRET_KEY = "aXRoZWltYQ==";

    /**
     * 过期时间：12 小时
     */
    private static final long EXPIRE_MILLIS = 12 * 60 * 60 * 1000L;

    /**
     * 生成 JWT：把自定义 claims 放进 payload，设置过期时间为 12 小时
     */
    public static String generateToken(Map<String, Object> claims) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setClaims(claims)
                .setExpiration(new Date(now + EXPIRE_MILLIS))
                .compact();
    }

    /**
     * 解析 JWT：验证签名与有效期，返回 Claims（payload）
     */
    public static Claims parseToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
