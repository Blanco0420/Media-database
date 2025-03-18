package com.media.database.media_database.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



import java.util.Collections;
import java.util.List;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public AuthenticationManager authenticationManager(ApiKeyAuthenticationProvider apiKeyAuthenticationProvider){
        return new ProviderManager(List.of(apiKeyAuthenticationProvider));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(AuthenticationManager authManager, HttpSecurity http) throws Exception {
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(new AntPathRequestMatcher("/api/**"));

        filter.setAuthenticationManager(authManager);

        http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorizeRequests ->
			authorizeRequests
				.requestMatchers("/api/**").authenticated()
                // .requestMatchers("/static/**", "/resources/**").permitAll()
				.anyRequest().permitAll()
			)
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
