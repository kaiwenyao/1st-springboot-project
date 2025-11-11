package com.itheima.config;

import com.itheima.intercepter.DemoIntercepter;
import com.itheima.intercepter.TokenIntercepter;
import jakarta.servlet.FilterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
/*    @Autowired
    private DemoIntercepter demoIntercepter;
    @Autowired
    private TokenIntercepter tokenIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenIntercepter).addPathPatterns("/**").excludePathPatterns(
                "/login");

    }*/

}
