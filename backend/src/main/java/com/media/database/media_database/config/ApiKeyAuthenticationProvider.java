package com.media.database.media_database.config;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthenticationProvider implements AuthenticationProvider{

    @Value("${api.key}")
    private String validApiKey;
    
    @Value("${api.secret}")
    private String validApiSecret;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apiKey = authentication.getPrincipal().toString();
        String apiSecret = authentication.getCredentials().toString();

        System.out.println(apiKey);
        System.out.println(apiSecret);
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        if(validApiKey.equals(apiKey) && validApiSecret.equals(apiSecret)){
            return new ApiKeyAuthenticationToken(apiKey, apiSecret, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        }

        throw new BadCredentialsException("Invalid API Key or Secret");
    }

    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(ApiKeyAuthenticationToken.class);
    }
}