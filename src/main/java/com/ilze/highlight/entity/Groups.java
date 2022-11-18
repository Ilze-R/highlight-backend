package com.ilze.highlight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
//@AllArgsConstructor
//@RequiredArgsConstructor
@Table(name = "group_collection")
public class Groups {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name ="group_name", unique = true, nullable = false, length = 20)
  private String groupName;

  @Column(name = "size", nullable = false)
  private int size;

  @Column(name = "strict", nullable = false)
  private boolean strict;

  @Column(name = "open", nullable = false)
  private boolean open;

  @Column(name ="description", length = 300)
  private String description;

  @Column(name = "create_time", nullable = false)
  private LocalDateTime createTime;


  @JsonIgnore
  @ManyToMany(
    fetch = FetchType.LAZY,
    cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE,
      CascadeType.DETACH,
      CascadeType.REFRESH})
//    , mappedBy = "groupName")

  @JoinTable(
    name = "groups_x_user",
    joinColumns = @JoinColumn(name = "groups_id"),
    inverseJoinColumns = @JoinColumn(name = "users_id"))

  private List<User> username;
}
