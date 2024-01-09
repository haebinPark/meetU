package com.example.codestates.comment.controller;

import com.example.codestates.comment.dto.CommentDto;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.mapper.CommentMapper;
import com.example.codestates.comment.repository.CommentRepository;
import com.example.codestates.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/comments")
@Slf4j
public class CommentController {
    private final static String COMMENT_DEFAULT_URL ="/v1/comments";
    private final CommentService commentService;
    private final CommentMapper mapper;



    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;

    }


    @PostMapping(params = "band_id")
    public ResponseEntity postComment(@RequestParam("band_id") long bandId,@RequestBody CommentDto.Post requestBody){
        Comment comment = mapper.commentPostDtoTocomment(requestBody);
        Comment createdComment = commentService.createComment(comment);
        URI location = UriCreator.createUri(COMMENT_DEFAULT_URL, createdComment.getCommentId());
        return ResponseEntity.created(location).build();
    }
    @GetMapping(params = "band_id")
    public ResponseEntity getComment(@RequestParam("band_id") long bandId){
        return null;
    }
    @DeleteMapping(params = {"band_id","comment_id"})
    public ResponseEntity deleteComment(@RequestParam("band_id") long bandId, @RequestParam("comment_id") long comentId){
        return null;
    }
    @PatchMapping(params = {"band_id","comment_id"})
    public ResponseEntity patchComment(@RequestParam("band_id") long bandId, @RequestParam("comment_id") long comentId){
        return null;
    }
}
