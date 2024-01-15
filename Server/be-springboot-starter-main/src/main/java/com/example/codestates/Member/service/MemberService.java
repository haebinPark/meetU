package com.example.codestates.Member.service;

import com.example.codestates.Member.repository.MemberRepository;
import com.example.codestates.Member.entitiy.Member;
import com.example.codestates.auth.utils.CustomAuthorityUtils;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.ExceptionCode;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
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
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member) {
        verifyExistEmail(member.getEmail());
        verifyExistNickName(member.getNickname());

        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);
        // Member 객체 생성 및 취미 연결, 선호 색상 설정
        //Member member = new Member();
        //beanUtils.copyNonNullProperties(memberPostDto, member);

        //member.setPreferredColor(preferredColor);
        // 취미 연결 추가해야함.


        // 추가: DB에 User Role 저장
        String role = authorityUtils.createRoles(member.getEmail());
        member.setRole(role);


        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
       Member foundmember = findmember(member.getMemberId());
       Member updatedMember = beanUtils.copyNonNullProperties(member,foundmember);
        return memberRepository.save(updatedMember);
    }

    public void deleteMember(@Positive long memberId) {
        Member foundMember = findmember(memberId);
        memberRepository.delete(foundMember);
    }

    public Page<Member> findMembers(String type, int page, int size) {
        return null;
    }

    @Transactional(readOnly = true)
    public Member findmember(long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
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