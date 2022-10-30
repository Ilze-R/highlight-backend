package com.ilze.highlight.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name ="username", unique = true, nullable = false, length = 100)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "create_time", nullable = false)
  private LocalDateTime createTime;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;

  @Transient
  private String accessToken;

  @Transient
  private String refreshToken;
}

////UserTry
//@Entity
//@Getter
//@Setter
//public class User {
//
//  @Id
//  private String userName;
//  private String userFirstName;
//  private String userLastName;
//  private String userPassword;
//
//  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinTable(name = "USER_ROLE",
//  joinColumns = {
//    @JoinColumn(name = "USER_ID")
//  },
//  inverseJoinColumns = {
//    @JoinColumn(name = "ROLE_ID")
//  })
//  private Set<Role> role;
//
//}
