package com.example.codestates.member.repository;

import com.example.codestates.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> { //기본 CRUD 메서드 포함됨
}
