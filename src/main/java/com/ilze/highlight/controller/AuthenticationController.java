package com.ilze.highlight.controller;

import com.ilze.highlight.service.AuthenticationService;
import com.ilze.highlight.service.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  private final LogoutService logoutService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
    @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(authenticationService.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws IOException {
    authenticationService.refreshToken(request, response);
  }

  @PostMapping("/logout")
  public ResponseEntity<String> logout(
    HttpServletRequest request,
    HttpServletResponse response,
    Authentication authentication
  ) {
    logoutService.logout(request, response, authentication);
    return ResponseEntity.ok("Logout successful");
  }

//  @PostMapping("sign-up") //api/authentication/sign-up
//  public ResponseEntity<?> signUp(@RequestBody User user) {
//
//    if (userService.findByUsername(user.getUsername()).isPresent()) {
//      return new ResponseEntity<>(HttpStatus.CONFLICT);
//    }
//    return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//  }
//
//  @PostMapping("sign-in") //api/authentication/sign-in
//  public ResponseEntity<?> signIn(@RequestBody User user){
//
//    return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
//  }
//
//  @PostMapping("refresh-token") // api/authentication/refresh-token?token=
//  public ResponseEntity<?> refreshToken(@RequestParam String token){
//
//    return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
//  }
}
