package com.ilze.highlight.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", unique = true, nullable = false, length = 100)
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
    cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE,
      CascadeType.DETACH,
      CascadeType.REFRESH
    })
  @JoinTable(name = "groups_x_user",
    joinColumns = { @JoinColumn(name = "users_id") },
    inverseJoinColumns = {@JoinColumn(name = "groups_id")})
  private Set<Groups> assignedGroups = new HashSet<>();


  public Set<Groups> getGroups(){
    return assignedGroups;
  }

  public void setGroups(Set<Groups> groups){
    this.assignedGroups = groups;
  }

  public void addGroup(Groups group) {
    this.assignedGroups.add(group);
    group.getUsers().add(this);
  }

  public void removeGroup(long id){
    Groups group = this.assignedGroups.stream().filter(g ->
      g.getId() == id).findFirst().orElse(null);
    if(group != null){
      this.assignedGroups.remove(group);
      group.getUsers().remove(this);
    }
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
}
