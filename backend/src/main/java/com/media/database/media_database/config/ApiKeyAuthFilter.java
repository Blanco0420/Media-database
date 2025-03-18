package com.media.database.media_database.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyAuthFilter  extends AbstractAuthenticationProcessingFilter{

    private static final String apiKeyHeader = "API-Key";
    private static final String apiSecretHeader = "API-Secret";

    public ApiKeyAuthFilter(RequestMatcher requiresAuth){
        super(requiresAuth);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        String apiKey = request.getHeader(apiKeyHeader);
        String apiSecret = request.getHeader(apiSecretHeader);

        if(apiKey == null || apiSecret == null){
            throw new RuntimeException("Missing Api key or secret");
        }

        ApiKeyAuthenticationToken authRequest = new ApiKeyAuthenticationToken(apiKey, apiSecret);
        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
    
}