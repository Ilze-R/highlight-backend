package com.ilze.highlight.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@AllArgsConstructor
//@RequiredArgsConstructor
@Table(name = "highlights")
public class GroupMembers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;


}
