package com.example.demo.coupon.mapper;

import com.example.demo.coupon.dto.CouponDto;
import com.example.demo.coupon.repository.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CouponMapper {
  CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

  Coupon createReqToEntity(CouponDto.CreateReq createReq);
  CouponDto.CreateRes entityToCreateRes(Coupon coupon);
}


