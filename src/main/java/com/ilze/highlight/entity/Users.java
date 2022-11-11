//package com.ilze.highlight.entity;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//@Data
//public class Users {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//@ManyToMany(fetch = FetchType.LAZY,
//cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//CascadeType.DETACH, CascadeType.REFRESH})
//
//    @JoinTable(
//            name = "xgroups_users",
//            joinColumns = @JoinColumn(name = "users_id"),
//            inverseJoinColumns = @JoinColumn(name = "groups_id")
//    )
//
//    private List<Groups> groups;
//}
