package com.example.codestates.member.mapper;

import com.example.codestates.member.dto.MemberDto;
import com.example.codestates.member.dto.MemberResponseDto;
import com.example.codestates.member.entitiy.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import com.example.codestates.member.entity.Member;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T14:30:35+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.21 (Azul Systems, Inc.)"
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
        member.setMbti( requestBody.getMbti() );
        member.setInteresting( requestBody.getInteresting() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setNickname( requestBody.getNickname() );
        member.setMbti( requestBody.getMbti() );
        member.setInteresting( requestBody.getInteresting() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member Member) {
        if ( Member == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

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
