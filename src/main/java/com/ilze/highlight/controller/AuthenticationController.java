package com.ilze.highlight.controller;

import com.ilze.highlight.entity.User;
import com.ilze.highlight.service.AuthenticationService;
import com.ilze.highlight.service.JwtRefreshTokenService;
import com.ilze.highlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication") //pre-path
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private UserService userService;

  @Autowired
  private JwtRefreshTokenService jwtRefreshTokenService;

  @PostMapping("sign-up") //api/authentication/sign-up
  public ResponseEntity<?> signUp(@RequestBody User user) {

    if (userService.findByUsername(user.getUsername()).isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
  }

  @PostMapping("sign-in") //api/authentication/sign-in
  public ResponseEntity<?> signIn(@RequestBody User user){

    return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
  }

  @PostMapping("refresh-token") // api/authentication/refresh-token?token=
  public ResponseEntity<?> refreshToken(@RequestParam String token){

    return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
  }
}
