package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    // 生成jwt令牌
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "admin");
        dataMap.put("id", 1);
        // itheima encode
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==")  // 签名算法 + 密钥
                // itheima encode
                .addClaims(dataMap) // 添加自定义信息 // 自定义载荷（payload）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间
                .compact(); // 生成 token 字符串
        System.out.println(jwt);
    }
    // 解析
    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9" +
                ".eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc2MjY0MjczMX0.dtgxyfoqLl4LLrTzj77tFpW5oYN1YInzVvrrCuWovT0";
        Claims claims = Jwts.parser().setSigningKey("aXRoZWltYQ==")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
