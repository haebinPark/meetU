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

    public Member createMember(Member member){
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: DB에 User Role 저장
        String role = authorityUtils.createRoles(member.getEmail());
        member.setRole(role);


        return null;
    }
      //회원 내 정보 수정(배경색 수정)v
    public Member updateUserStyle(Long userId, Member.NickNameColor nickNameColor) {
        Member findMember = findVerifiedMember(userId);
        findMember.setStyleCode(nickNameColor);
        return memberRepository.save(findMember);
    }

    public Member updateMember(Member member){

        return null;
    }
    public void deleteMember(@Positive long memberId){

    }

    public Page<Member> findMembers(String type, int page, int size) {
        return null;

    }
}
