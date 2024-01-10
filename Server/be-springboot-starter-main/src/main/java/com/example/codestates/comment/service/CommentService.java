package com.example.codestates.comment.service;

import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.repository.CommentRepository;
import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.ExceptionCode;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional

public class CommentService {

    private final CommentRepository commentRepository;
    private final CustomBeanUtils<Comment> beanUtils;
    public CommentService(CommentRepository commentRepository, CustomBeanUtils<Comment> beanUtils) {
        this.commentRepository = commentRepository;
        this.beanUtils = beanUtils;
    }

    public Comment createComment(long bandId, Comment comment){
            return commentRepository.save(comment);

    }
    public Comment updateComment(Comment comment){
        Comment foundComment = findComment(comment.getCommentId());
        Comment updatedComment = beanUtils.copyNonNullProperties(comment,foundComment);

        return commentRepository.save(updatedComment);
    }
    @Transactional(readOnly = true)
    public Comment findComment(long commentId){
        return commentRepository
                .findById(commentId)
                .orElseThrow(()-> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public Page<Comment> findAll(int page, int size){
        return commentRepository.findAll(PageRequest.of(page-1,size));
    }

    public void deleteComment(long commentId){
        Comment foundComment =findComment(commentId);
        commentRepository.delete(foundComment);
    }
}
