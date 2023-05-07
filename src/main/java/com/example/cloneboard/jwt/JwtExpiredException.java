package com.example.cloneboard.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtExpiredException extends AuthenticationException  {
    public JwtExpiredException(String message) {
        super(message);
    }
}
