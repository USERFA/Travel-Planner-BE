package com.example.travelPlanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //treat this class as a configuration
public class config implements WebMvcConfigurer {
	
	
//	global CORS rules that apply to all controllers and end points (fct below)


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // apply to all paths
                .allowedOrigins("http://localhost:3000") // allow React dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
