package com.example.demo.member.mapper;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.repository.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
  MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

  Member createReqToEntity(MemberDto.CreateReq createReq);

}
