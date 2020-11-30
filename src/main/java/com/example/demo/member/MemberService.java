package com.example.demo.member;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.repository.Member;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberDto.CreateRes createMember(MemberDto.CreateReq reqDto) {
    String name = reqDto.getName();
    Member m = MemberDto.CreateReq.toEntity(reqDto);
    Member newMember = memberRepository.save(m);

//    memberRepository.save(Member.builder().name(name).build());
    return MemberDto.CreateRes.builder().name(name).build();
  }
}
