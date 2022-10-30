package com.ilze.highlight.service;

import com.ilze.highlight.entity.User;
import com.ilze.highlight.security.UserPrincipal;
import com.ilze.highlight.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtProvider jwtProvider;

  @Autowired
  private JwtRefreshTokenService jwtRefreshTokenService;

  @Override
  public User signInAndReturnJWT(User signInRequest){
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
    );

    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
    String jwt = jwtProvider.generateToken(userPrincipal);

    User signInUser = userPrincipal.getUser();
    signInUser.setAccessToken(jwt);
    signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getId()).getTokenId());

    return signInUser;
  }
}
