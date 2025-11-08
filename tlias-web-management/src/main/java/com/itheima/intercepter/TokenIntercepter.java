package com.itheima.intercepter;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求路径
        String requestUri = request.getRequestURI();

/*        // 判断路径 放行与否
        if (requestUri.contains("/login")) {
            log.info("请求登陆，放行！");
            return true;
        }*/
        // 获取请求头中的token
        String token = request.getHeader("token");
        // 判断是否存在
        if (token == null || token.isEmpty()) {
            log.info("token不存在 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 如果存在则校验
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 合法 放行！
        return true;
    }
}
