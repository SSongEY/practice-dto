package com.example.demo.member.dto;

import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.repository.Member;
import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class CreateReq {
    @NotNull
    private String name;

    public static Member toEntity(CreateReq createReq) {
      return MemberMapper.INSTANCE.createReqToEntity(createReq);
    }
  }

  @Getter
  @Builder
  public static class CreateRes {
    private String name;
  }
}
