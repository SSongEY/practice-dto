package com.example.demo.coupon.dto;

import com.example.demo.coupon.mapper.CouponMapper;
import com.example.demo.coupon.repository.Coupon;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class CreateReq {
    @NotBlank
    private String name;
    @NotNull
    private String type;
    @NotNull
    private Integer discountRate;

    public Coupon toEntity() {
      return CouponMapper.INSTANCE.createReqToEntity(this);
    }
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class CreateRes {
    private String name;

    public static CreateRes of(Coupon coupon) {
      return CouponMapper.INSTANCE.entityToCreateRes(coupon);
    }
  }
}


