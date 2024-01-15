//package com.example.codestates.Member.mapper;
//
//import com.example.codestates.Member.dto.MemberDto;
//import com.example.codestates.Member.dto.MemberResponseDto;
//import com.example.codestates.Member.entitiy.Member;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingConstants;
//
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface MemberMapper {
//    Member memberPostDtoToMember(MemberDto.Post requestBody);
//    Member memberPatchDtoToMember(MemberDto.Patch requestBody);
//
//    MemberResponseDto memberToMemberResponseDto(Member Member);
//    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> Members);
//}

package com.example.codestates.Member.mapper;

import com.example.codestates.Member.dto.MemberDto;
import com.example.codestates.Member.dto.MemberResponseDto;
import com.example.codestates.Member.entitiy.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * MapStruct 라이브러리를 사용하여, 엔티티 객체를 DTO로, DTO를 엔티티 객체로 매핑
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {

    // MemberDto.Post 객체를 Member 엔티티로 변환
    Member memberPostDtoToMember(MemberDto.Post requestBody);

    // MemberDto.Patch 객체를 Member 엔티티로 변환
    Member memberPatchDtoToMember(MemberDto.Patch requestBody);

    // Member 엔티티를 MemberResponseDto 객체로 변환
    MemberResponseDto memberToMemberResponseDto(Member member);

    // Member 엔티티 리스트를 MemberResponseDto 리스트로 변환
    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members);
}
