package com.example.codestates.member.mapper;

import com.example.codestates.member.dto.MemberDto;
import com.example.codestates.member.dto.MemberResponseDto;
import com.example.codestates.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T21:55:05+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setNickname( requestBody.getNickname() );
        member.setPassword( requestBody.getPassword() );
        member.setEmail( requestBody.getEmail() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( requestBody.getMemberId() );
        member.setNickname( requestBody.getNickname() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member Member) {
        if ( Member == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        memberResponseDto.setMemberId( Member.getMemberId() );
        memberResponseDto.setEmail( Member.getEmail() );
        if ( Member.getStyleCode() != null ) {
            memberResponseDto.setStyleCode( Member.getStyleCode().name() );
        }

        return memberResponseDto;
    }

    @Override
    public List<MemberResponseDto> membersToMemberResponseDtos(List<Member> Members) {
        if ( Members == null ) {
            return null;
        }

        List<MemberResponseDto> list = new ArrayList<MemberResponseDto>( Members.size() );
        for ( Member member : Members ) {
            list.add( memberToMemberResponseDto( member ) );
        }

        return list;
    }
}
