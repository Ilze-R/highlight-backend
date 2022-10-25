package com.ilze.highlight.service;

import com.ilze.highlight.dao.RoleDao;
import com.ilze.highlight.dao.UserDao;
import com.ilze.highlight.entity.Role;
import com.ilze.highlight.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User registerNewUser(User user) {

    Role role = roleDao.findById("User").get();

    Set<Role> roles = new HashSet<>();
    roles.add(role);
    user.setRole(roles);

    user.setUserPassword(getEncodedPassword(user.getUserPassword()));
    return userDao.save(user);
  }

  public void initRolesAndUser() {
    Role adminRole = new Role();
    adminRole.setRoleName("Admin");
    adminRole.setRoleDescription("Admin role");
    roleDao.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleName("User");
    userRole.setRoleDescription("User role for new created user");
    roleDao.save(userRole);

    User adminUser = new User();
    adminUser.setUserFirstName("admin");
    adminUser.setUserLastName("admin");
    adminUser.setUserName("admin123");
    adminUser.setUserPassword(getEncodedPassword("admin@pass"));
    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);
    adminUser.setRole(adminRoles);
    userDao.save(adminUser);

//    User user = new User();
//    user.setUserFirstName("tim");
//    user.setUserLastName("green");
//    user.setUserName("green123");
//    user.setUserPassword(getEncodedPassword("user@pass"));
//    Set<Role> userRoles = new HashSet<>();
//    adminRoles.add(userRole);
//    user.setRole(userRoles);
//    userDao.save(user);

  }

  public String getEncodedPassword(String password) {
    return passwordEncoder.encode(password);
  }
}

