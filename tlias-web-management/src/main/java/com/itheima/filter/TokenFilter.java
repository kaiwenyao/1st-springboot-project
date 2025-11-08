package com.itheima.filter;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径
        String requestUri = request.getRequestURI();

        // 判断路径 放行与否
        if (requestUri.contains("/login")) {
            log.info("请求登陆，放行！");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 获取请求头中的token
        String token = request.getHeader("token");
        // 判断是否存在
        if (token == null || token.isEmpty()) {
            log.info("token不存在 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        // 如果存在则校验
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        // 合法 放行！
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
