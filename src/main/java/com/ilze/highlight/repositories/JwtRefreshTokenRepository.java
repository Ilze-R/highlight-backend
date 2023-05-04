package com.ilze.highlight.repositories;

import com.ilze.highlight.entity.JwtRefreshTokenOUT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshTokenOUT, String> {
}
