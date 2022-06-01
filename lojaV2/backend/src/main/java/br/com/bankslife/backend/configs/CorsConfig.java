package br.com.bankslife.backend.configs;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000", "http://localhost:8081", "http://localhost:8080", "http://localhost:8081/fotos")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "configure")
                .allowCredentials(true)
        ;
    }

}