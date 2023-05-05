package com.ilze.highlight.controller;

import com.ilze.highlight.repositories.UserRepository;
import com.ilze.highlight.entity.enums.Role;
import com.ilze.highlight.entity.User;
import com.ilze.highlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user") // pre-path
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;


//  @PutMapping("change/{role}") // api/user/change/{role}
//  public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role) {
//
//    userService.changeRole(role, userPrincipal.getUsername());
//
//    return ResponseEntity.ok(true);
//  }


  @GetMapping("/{id}") // api/user/4
  public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

//  @DeleteMapping("/delete/{id}")
//  public ResponseEntity removeUser(@PathVariable Long id) {
//    userService.deleteUser(id);
//    return new ResponseEntity(HttpStatus.OK);
//  }


}
