package com.example.codestates.comment.service;

import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional

public class CommentService {

    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;

    }

    public Comment createComment(Comment comment){
        Comment savedComment= commentRepository.save(comment);
        return savedComment;
    }
}
