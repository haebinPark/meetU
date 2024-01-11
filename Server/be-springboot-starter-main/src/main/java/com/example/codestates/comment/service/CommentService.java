package com.example.codestates.comment.service;

import com.example.codestates.band.service.BandService;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.mapper.CommentMapper;
import com.example.codestates.comment.repository.CommentRepository;
import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.ExceptionCode;
import com.example.codestates.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.codestates.band.entitiy.Band;

@Service
@Transactional

public class CommentService {

    private final CommentRepository commentRepository;
    private final CustomBeanUtils<Comment> beanUtils;
    private final CommentMapper commentMapper;
    private final BandService bandService;

    public CommentService(CommentRepository commentRepository, CustomBeanUtils<Comment> beanUtils, CommentMapper commentMapper, BandService bandService) {
        this.commentRepository = commentRepository;
        this.beanUtils = beanUtils;
        this.commentMapper = commentMapper;
        this.bandService = bandService;
    }

    public Comment createComment(long bandId, Comment comment) {
        Band band = bandService.findById(bandId).orElse(null);
        if (band == null) {
            throw new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND);
        }
        comment.setBand(band);
        return commentRepository.save(comment);

    }

    public Comment updateComment(long bandId,long commentId,Comment comment) {
        Band band = bandService.findById(bandId).orElse(null);
        if (band == null) {
            throw new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND);
        }
        Comment foundComment = findComment(commentId);
        Comment updatedComment = beanUtils.copyNonNullProperties(comment, foundComment);

        return commentRepository.save(updatedComment);
    }

    @Transactional(readOnly = true)
    public Comment findComment(long commentId) {
        return commentRepository
                .findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public Page<Comment> findComment(long bandId,int page, int size) {
        Band band = bandService.findById(bandId).orElse(null);
        if (band == null) {
            throw new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND);
        }

        return commentRepository.findAll(PageRequest.of(page - 1, size));
    }

    public void deleteComment(long bandId,long commentId) {
        Band band = bandService.findById(bandId).orElse(null);
        if (band == null) {
            throw new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND);
        }
        Comment foundComment = findComment(commentId);
        commentRepository.delete(foundComment);
    }
}
