package com.ilze.highlight.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
//@AllArgsConstructor
//@RequiredArgsConstructor
@Table(name = "highlights")
public class Highlights {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "create_time", nullable = false)
  private LocalDateTime createTime;


}
