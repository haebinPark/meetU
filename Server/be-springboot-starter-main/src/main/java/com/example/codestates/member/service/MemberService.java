package com.example.codestates.member.service;

import com.example.codestates.member.repository.MemberRepository;
import com.example.codestates.member.entitiy.Member;
import com.example.codestates.auth.utils.CustomAuthorityUtils;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Positive;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    //회원 생성
    public Member createMember(Member member) {
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: DB에 User Role 저장
        String role = authorityUtils.createRoles(member.getEmail());
        member.setRole(role);


        return null;
    }

    //회원 정보 수정
    public Member updateMember(MemberDto.Patch memberPatchDto, @Positive long memberId) {
        // 회원 정보 찾기
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        // 정보 업데이트
        beanUtils.copyNonNullProperties(memberPatchDto, member);
        return memberRepository.save(member);
    }

      /*//회원 내 정보 수정(배경색 수정) 수정 및 병합 필요 일단 무시
    public Member updateUserStyle(Long userId, Member.NickNameColor nickNameColor) {
        Member findMember = findVerifiedMember(userId);
        findMember.setStyleCode(nickNameColor);
        return memberRepository.save(findMember);
    }*/

    //회원 삭제
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
