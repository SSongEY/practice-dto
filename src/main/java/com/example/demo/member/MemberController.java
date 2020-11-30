package com.example.demo.member;

import com.example.demo.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/api/members")
  public MemberDto.CreateRes createMember(@RequestBody @Valid MemberDto.CreateReq reqDto) {
    return memberService.createMember(reqDto);
  }
}
