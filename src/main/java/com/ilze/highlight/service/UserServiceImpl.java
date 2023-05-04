package com.ilze.highlight.service;

import com.ilze.highlight.repositories.GroupsRepository;
import com.ilze.highlight.repositories.UserRepository;
import com.ilze.highlight.entity.Groups;
import com.ilze.highlight.entity.enums.Role;
import com.ilze.highlight.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final GroupsRepository groupsRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, GroupsRepository groupsRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.groupsRepository = groupsRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Role.USER);
    user.setCreateTime(LocalDateTime.now());

    return userRepository.save(user);
  }

  @Override
  public Optional<User> findByUsername(String username){
    return userRepository.findByUsername(username);
  }

  @Override
  @Transactional //Transactional is required when executing an update/delete query
  public void changeRole(Role newRole, String username){
    userRepository.updateUserRole(username, newRole);
  }

  @Override
  public List<User> findAllUsers(){
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
  return userRepository.findById(id).orElse(null);
  }

  @Override
  public void addUserToGroup(Long usersId, Groups group) {
    User user = getUserById(usersId);

    if(user != null){
      user.getGroups().add(group);
      userRepository.save(user);
    }
  }

  @Override
  public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public User assignGroupToUser(Long userId, Long groupId) {
    Set<Groups> groupSet = null;
    User user = userRepository.findById(userId).get();
    Groups group = groupsRepository.findById(groupId).get();
    groupSet = user.getAssignedGroups();
    groupSet.add(group);
    user.setAssignedGroups(groupSet);
    return userRepository.save(user);
  }

//  @Override
//  public void addUserToGroup(Long usersId, Groups group) {
////    User user = userService.getUserById(usersId);

//    if(user != null){
//      user.getGroups().add(group);
//  }

}
