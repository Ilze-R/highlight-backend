package com.ilze.highlight.repositories;

import com.ilze.highlight.entity.enums.Role;
import com.ilze.highlight.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
  List<User> findAll();

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

//  @Modifying
//  @Query("update User set role = :role where username = :username")
//  void updateUserRole(@Param("username") String username, @Param("role")Role role);

  //  List<User> findUsersByGroupsId(Long groupId);
}


