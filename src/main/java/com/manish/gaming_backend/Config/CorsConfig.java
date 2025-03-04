package com.manish.gaming_backend.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Value("${Frontend.URl}")
    private String frontendUrl;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Apply to all endpoints
                        .allowedOrigins(frontendUrl) // Allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed methods
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true) // Allow credentials (cookies)
                        .maxAge(3600); // Cache preflight response for 1 hour
            }
        };
    }
}

