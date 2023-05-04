package com.ilze.highlight.entity;

import jakarta.persistence.*;
import lombok.Data;



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
