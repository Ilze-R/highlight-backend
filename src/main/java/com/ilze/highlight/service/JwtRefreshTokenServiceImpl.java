package com.ilze.highlight.service;

import com.ilze.highlight.dao.JwtRefreshTokenRepository;
import com.ilze.highlight.dao.UserRepository;
import com.ilze.highlight.entity.JwtRefreshToken;
import com.ilze.highlight.entity.User;
import com.ilze.highlight.security.UserPrincipal;
import com.ilze.highlight.security.jwt.JwtProvider;
import com.ilze.highlight.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;

@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService {

  @Value("${app.jwt.refresh-expiration-in-ms}")
  private Long REFRESH_EXPIRATION_IN_MS;

  @Autowired
  private JwtRefreshTokenRepository jwtRefreshTokenRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtProvider jwtProvider;

  @Override
  public JwtRefreshToken createRefreshToken(Long userId) {

    JwtRefreshToken jwtRefreshToken = new JwtRefreshToken();

    jwtRefreshToken.setTokenId(UUID.randomUUID().toString());
    jwtRefreshToken.setUserId(userId);
    jwtRefreshToken.setCreateDate(LocalDateTime.now());
    jwtRefreshToken.setExpirationDate(LocalDateTime.now().plus(REFRESH_EXPIRATION_IN_MS, ChronoUnit.MILLIS));

    return jwtRefreshTokenRepository.save(jwtRefreshToken);
  }

  @Override
  public User generateAccessTokenFromRefreshToken(String refreshTokenId) {

    JwtRefreshToken jwtRefreshToken = jwtRefreshTokenRepository.findById(refreshTokenId).orElseThrow();

    if (jwtRefreshToken.getExpirationDate().isBefore(LocalDateTime.now())) {
      throw new RuntimeException("JWT refresh token is not valid.");
    }

    User user = userRepository.findById(jwtRefreshToken.getUserId()).orElseThrow();

    UserPrincipal userPrincipal = UserPrincipal.builder()
      .id(user.getId())
      .username(user.getUsername())
      .password(user.getPassword())
      .authorities(Set.of(SecurityUtils.convertToAuthority(user.getRole().name())))
      .build();

    String asscessToken = jwtProvider.generateToken(userPrincipal);

    user.setAccessToken(asscessToken);
    user.setRefreshToken(refreshTokenId);

    return user;
  }

}
