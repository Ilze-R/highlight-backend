package com.ilze.highlight.service;

import com.ilze.highlight.entity.Role;
import com.ilze.highlight.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  User saveUser(User user);

  Optional<User> findByUsername(String username);

  void changeRole(Role newRole, String username);

  List<User> findAllUsers();
}
