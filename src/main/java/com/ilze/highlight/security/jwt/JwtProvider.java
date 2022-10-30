package com.ilze.highlight.security.jwt;

import com.ilze.highlight.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

  Authentication getAuthentication(HttpServletRequest request);

  boolean isTokenValid(HttpServletRequest request);
}
