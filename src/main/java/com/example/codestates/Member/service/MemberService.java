package com.example.codestates.Member.service;

import com.example.codestates.Member.dto.MemberDto;
import com.example.codestates.Member.entitiy.Member;
import com.example.codestates.Member.repository.MemberRepository;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
        this.passwordEncoder = passwordEncoder;
    }

    public Member createMember(MemberDto.Post memberPostDto, List<Long> hobbyIds, String preferredColor) {
        // 이메일 닉네임 중복 확인
        verifyExistEmail(memberPostDto.getEmail());
        verifyExistNickName(memberPostDto.getNickname());

        // 비밀번호 암호화
        memberPostDto.setPassword(passwordEncoder.encode(memberPostDto.getPassword()));

        // Member 객체 생성 및 취미 연결, 선호 색상 설정
        Member member = new Member();
        beanUtils.copyNonNullProperties(memberPostDto, member);

        member.setPreferredColor(preferredColor);
        // 취미 연결 추가해야함.

        return memberRepository.save(member);
    }

    public Member updateMember(MemberDto.Patch memberPatchDto, @Positive long memberId) {
        // 회원 정보 찾기
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        // 정보 업데이트
        beanUtils.copyNonNullProperties(memberPatchDto, member);
        return memberRepository.save(member);
    }

    public void deleteMember(@Positive long memberId) {
        memberRepository.deleteById(memberId);
    }

    public Page<Member> findMembers(String type, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        // 회원 목록 조회
        return memberRepository.findAll(pageRequest);
    }

    // 유효성 검사
    private void verifyExistEmail(String email) {
        Optional<Member> existingMember = memberRepository.findByEmail(email);
        if (existingMember.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
    }

    private void verifyExistNickName(String nickname) {
        Optional<Member> existingMember = memberRepository.findByNickname(nickname);
        if (existingMember.isPresent()) {
            throw new IllegalArgumentException("Nickname already exists");
        }
    }
}

