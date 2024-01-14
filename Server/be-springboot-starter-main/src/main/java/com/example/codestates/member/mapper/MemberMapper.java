package com.example.codestates.member.mapper;

import com.example.codestates.member.dto.MemberPatchDto;
import com.example.codestates.member.dto.MemberPostDto;
import com.example.codestates.member.dto.MemberResponseDto;
import com.example.codestates.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
