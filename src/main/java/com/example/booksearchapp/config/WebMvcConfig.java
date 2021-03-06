package com.example.booksearchapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {
    @Autowired
    private Environment env;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                String corsAllowedUrl = env.getProperty("cors.allowed-url");

                registry.addMapping("/**")
                        .allowedOrigins(corsAllowedUrl)
                        .allowedMethods("*")
                        .allowedHeaders("*")
                ;
            }
        };
    }
}