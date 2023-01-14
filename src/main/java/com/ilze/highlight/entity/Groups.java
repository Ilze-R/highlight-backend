package com.ilze.highlight.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "group_collection")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")
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

  @Column(name = "create_time")
  private LocalDateTime createTime;



  @ManyToMany(fetch = FetchType.LAZY,
  cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE,
    CascadeType.DETACH,
    CascadeType.REFRESH
  },
  mappedBy = "assignedGroups")
  private Set<User> usersSet = new HashSet<>();


  public Set<User> getUsers() {
    return usersSet;
  }

  public void setUsers(Set<User> usersSet) {
    this.usersSet = usersSet;
  }

  @PrePersist
  public void prePersist(){
    createTime = LocalDateTime.now();
  }


}
