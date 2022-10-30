package com.ilze.highlight.security;

import com.ilze.highlight.entity.User;
import com.ilze.highlight.service.UserService;
import com.ilze.highlight.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  public UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userService.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

    return UserPrincipal.builder()
      .user(user)
      .id(user.getId())
      .username(user.getUsername())
      .password(user.getPassword())
      .authorities(authorities)
      .build();
  }
}
