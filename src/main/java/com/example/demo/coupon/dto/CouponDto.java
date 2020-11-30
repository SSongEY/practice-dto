package com.example.demo.coupon.dto;

import com.example.demo.coupon.mapper.CouponMapper;
import com.example.demo.coupon.repository.Coupon;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    public Coupon createReqToEntity() { //check req는 static으로 안하면 this로 param 넘길 수 있음, res는 static 필요
      return CouponMapper.INSTANCE.createReqToEntity(this);
    }
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PUBLIC) //check - access 걸면 mapperImpl에서 생성자 접근이 안된다고 함.
  public static class CreateRes {
    @NotBlank
    private String name;

    public static CreateRes entityToCreateRes(Coupon coupon) {
      return CouponMapper.INSTANCE.entityToCreateRes(coupon);
    }
  }
}


