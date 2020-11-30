package com.example.demo.coupon.repository;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Coupon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @NotNull
  String name;

  @NotNull
  private String type;

  @NotNull
  private int discountRate;

  @NotNull
  private boolean valid;

  @CreatedDate
  LocalDateTime created;

  @Builder
  private Coupon(String name, String type, int discountRate) {
    this.name = name;
    this.type = type;
    this.discountRate = discountRate;

    this.valid = true;
  }
}
