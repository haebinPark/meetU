package com.example.codestates.Member.repository;

import com.example.codestates.Member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 이메일을 기준으로 Member 찾음
    Optional<Member> findByEmail(String email);

    // 닉네임을 기준으로 Member 찾음
    Optional<Member> findByNickname(String nickname);

// 추가적인 메소드가 필요하면
