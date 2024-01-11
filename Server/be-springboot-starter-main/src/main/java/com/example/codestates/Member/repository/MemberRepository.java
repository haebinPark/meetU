package com.example.codestates.Member.repository;

import com.example.codestates.Member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
