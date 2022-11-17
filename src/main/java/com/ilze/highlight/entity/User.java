package com.ilze.highlight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
//@AllArgsConstructor
//@RequiredArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name ="username", unique = true, nullable = false, length = 100)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "create_time", nullable = false)
  private LocalDateTime createTime;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;

  @Transient
  private String accessToken;

  @Transient
  private String refreshToken;


  @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.DETACH, CascadeType.REFRESH})

  @JoinTable(
    name = "groups_x_user",
    joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "groups_id")
  )
  private List<Groups> groupName;


//  @ManyToMany(
//    fetch = FetchType.LAZY,
//    cascade = {
//      CascadeType.PERSIST,
//      CascadeType.MERGE,
//      CascadeType.DETACH,
//      CascadeType.REFRESH})
//
//  @JoinTable(
//    name = "groups_x_user",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "group_id"))
//
//    private List<Groups> groupName;
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
