package com.example.codestates.Member.service;

import com.example.codestates.Member.repository.MemberRepository;
import com.example.codestates.Member.entitiy.Member;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Positive;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
    }

    public Member createMember(Member member){

        return null;
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
