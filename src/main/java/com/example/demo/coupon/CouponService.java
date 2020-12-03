package com.example.demo.coupon;

import com.example.demo.coupon.dto.CouponDto;
import com.example.demo.coupon.repository.Coupon;
import com.example.demo.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

  private final CouponRepository couponRepository;

  CouponDto.CreateRes createCoupon(CouponDto.CreateReq reqDto) {
    Coupon newCoupon = couponRepository.save(reqDto.toEntity());

    CouponDto.CreateRes result = CouponDto.CreateRes.of(Coupon.builder().name(" ").build());
    return result;
  }
}
