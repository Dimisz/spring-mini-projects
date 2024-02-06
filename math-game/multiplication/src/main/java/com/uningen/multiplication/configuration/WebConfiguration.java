package com.uningen.multiplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(final CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**").allowedOrigins(
                "http://localhost:5173/"
        );
    }
}
