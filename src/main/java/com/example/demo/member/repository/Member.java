package com.example.demo.member.repository;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @NotNull
  private String name;

  @CreatedDate
  private LocalDateTime created;

  @CreatedDate
  private LocalDateTime updated;

  @Builder
  public Member(String name) {
    this.name = name;
  }
}
