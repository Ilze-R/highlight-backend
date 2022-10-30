package com.ilze.highlight.dao;

import com.ilze.highlight.entity.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {
}
