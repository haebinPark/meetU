package com.example.codestates.comment.repository;

import com.example.codestates.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //ComentId로 findby
    Optional<Comment> findById(Long comentId);

    Optional<Comment> findbyNickname(String nickname);
}
