package com.example.codestates.member.service;

import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.ExceptionCode;
import com.example.codestates.member.entity.Member;
import com.example.codestates.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService { //비지니스 로직 구현,엔티티 반환

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원의 존재 여부를 검증, 존재하지 않을 경우 예외를 던지는 내부 메서드v
    private Member findVerifiedMember(long userId) {
        return memberRepository.findById(userId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    //회원 내 정보 조회(배경색 포함)v
    public Member findMember(Long userId) {
        return findVerifiedMember(userId);
    }


    //회원 내 정보 수정(배경색 수정)v
    public Member updateUserStyle(Long userId, Member.NickNameColor nickNameColor) {
        Member findMember = findVerifiedMember(userId);
        findMember.setStyleCode(nickNameColor);
        return memberRepository.save(findMember);
    }

    //사용 가능한 닉네임 배경색 전체 조회
    public List findAllStyle {
    }
}
