package com.ilze.highlight.controller;

import com.ilze.highlight.entity.User;
import com.ilze.highlight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin") //pre-path
public class AdminController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> userList = userRepository.findAll();
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }
}
