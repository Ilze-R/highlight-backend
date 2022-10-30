package com.ilze.highlight.service;

import com.ilze.highlight.entity.User;

public interface AuthenticationService {
  User signInAndReturnJWT(User signInRequest);
}
