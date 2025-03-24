package com.media.database.media_database.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // @Override
    // public void addCorsMappings(CorsRegistry registry){
    //     registry.addMapping("/api/**")
    //     .allowedOrigins("http://localhost:5173")
    //     .allowedMethods("GET", "POST")
    //     .allowedHeaders("*")
    //     .exposedHeaders("*")
    //     .maxAge(3600);
    // }
}
// @Configuration
// public class CorsConfig {
//     @Bean
//     public CorsFilter corsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowCredentials(true);
//         config.setAllowedOrigins(List.of("http://localhost:5173"));
//         config.setAllowedMethods(List.of("GET", "POST"));
//         config.setAllowedHeaders(List.of("Access-Control-Allow-Origin","Authorization", "Content-type", "x-api-key"));

//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }
// }
