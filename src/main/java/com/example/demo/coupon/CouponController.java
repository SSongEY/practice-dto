package com.example.demo.coupon;

import com.example.demo.coupon.dto.CouponDto;
import com.example.demo.coupon.repository.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CouponController {

  private final CouponService couponService;

  @PostMapping("/api/coupons")
  public CouponDto.CreateRes createCoupon(@RequestBody @Valid CouponDto.CreateReq reqDto) {
    return couponService.createCoupon(reqDto);
  }
}
