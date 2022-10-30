package com.ilze.highlight.dao;

import com.ilze.highlight.entity.Role;
import com.ilze.highlight.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

  Optional<User> findByUsername(String username);

  @Modifying
  @Query("update User set role = :role where username = :username")
  void updateUserRole(@Param("username") String username, @Param("role")Role role);
}



//@Repository
//public interface UserDao extends CrudRepository<User, String> {
//}
