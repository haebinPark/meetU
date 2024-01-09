package com.example.codestates.user.repository;

import com.example.codestates.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //기본 CRUD 메서드 포함됨
}
