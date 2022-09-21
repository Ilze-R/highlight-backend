package com.ilze.highlight.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "x_groups")
@Data
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private int size;

    @Column(name = "strict")
    private boolean strict;

    @Column(name = "closed")
   private boolean closed;

@ManyToMany(
        fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
                CascadeType.DETACH,
                CascadeType.REFRESH})

    @JoinTable(
            name = "xgroups_users",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))

    private List<Users> users;
}
