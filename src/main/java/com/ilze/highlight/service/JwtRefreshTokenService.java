package com.ilze.highlight.service;

import com.ilze.highlight.entity.JwtRefreshToken;
import com.ilze.highlight.entity.User;

public interface JwtRefreshTokenService {
  JwtRefreshToken createRefreshToken(Long userId);

  User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
