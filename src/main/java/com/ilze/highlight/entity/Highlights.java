package com.ilze.highlight.entity;

import jakarta.persistence.*;
import lombok.Data;
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
