package com.example.demo.coupon;

import com.example.demo.coupon.dto.CouponDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CouponController {
  private Logger logger = LoggerFactory.getLogger(CouponController.class);
  private final CouponService couponService;

  @PostMapping("/api/coupons")
  public CouponDto.CreateRes createCoupon(@RequestBody @Valid CouponDto.CreateReq reqDto) {
    return couponService.createCoupon(reqDto);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    List<String> errorFields = e.getBindingResult().getFieldErrors().stream()
      .map(FieldError::getField)
      .collect(Collectors.toList());
    String joinedErrorFields = String.join(",", errorFields);

    logger.error("MethodArgumentNotValidException: {}", errorFields);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request Param: "+joinedErrorFields);
  }

}
