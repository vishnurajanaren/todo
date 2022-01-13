package com.example.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiRequestHandlerConfig implements WebMvcConfigurer {

    // Register ApiHandlerInterceptorAdapter in Bean
    @Autowired
    AuthInterceptor authInterceptor;

    // Add the intercepter to the spring configuration
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).excludePathPatterns(
                "/swagger-ui/**",
                "/swagger-ui.html",
                "/v3/api-docs/**"
        );

    }
}
