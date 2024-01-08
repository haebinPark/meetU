package com.example.codestates.coment.repository;

import com.example.codestates.coment.entity.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComentRepository extends JpaRepository<Coment,Long> {
    //ComentId로 findby
    Optional<Coment> findById(Long comentId);

    Optional<Coment> findbyNickname(String nickname);
}
