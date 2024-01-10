package com.example.codestates.repository;

import com.example.codestates.entity.Mention;
import com.example.codestates.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentionRepository extends JpaRepository<Mention, Long> {
//    List<Mention> findAllByReceiveUserId(User findAllByReceiveUserId);

    static List<Mention> findAllBySenderUserId(User findAllBySenderUserId) {
        return null;
    }

    List<Mention> findBySenderUserId(User findAllBySenderUserId);
}