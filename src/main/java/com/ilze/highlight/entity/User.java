package com.ilze.highlight.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ilze.highlight.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "users")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")
public class User implements UserDetails {
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

//  @Column(name = "create_time", nullable = false)
//  private LocalDateTime createTime;


  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

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

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  private List<Token> tokens;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;


  public Role getRole() {
    return role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

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

}
