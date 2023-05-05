package com.ilze.highlight.exceptions;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(Long id) {
    super("User not found.");
  }

  public UserNotFoundException(String email) {
    super("User with email " + email + " not found.");
  }
}
