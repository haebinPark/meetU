package com.example.codestates.Member.service;

import com.example.codestates.Member.repository.MemberRepository;
import com.example.codestates.Member.entitiy.Member;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
    }

    public Member createUser(){
        return null;
    }

    public Member updateUser(){
        return null;

    }
    public Member findUser(){
        return null;
    }
    public void deleteUser(){

    }
}
