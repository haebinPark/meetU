package com.example.codestates.comment.controller;

import com.example.codestates.comment.dto.CommentDto;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.mapper.CommentMapper;
import com.example.codestates.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated
public class CommentConroller {
    private final CommentService commentService;
    private final CommentMapper mapper;
    public CommentConroller(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }


    @PostMapping(value = "/comments", params = "band_id")
    public ResponseEntity postComment(@RequestParam("band_id") long bandId,@RequestBody CommentDto.Post requestBody){
        Comment createdComment = CommentService.createComent(mapper.comentPostDtoTocoment(requestBody));
        return null;
    }
    @GetMapping(value = "/comments", params = "band_id")
    public ResponseEntity getComment(@RequestParam("band_id") long bandId){
        return null;
    }
    @DeleteMapping(value = "/comments", params = {"band_id","comment_id"})
    public ResponseEntity deleteComment(@RequestParam("band_id") long bandId, @RequestParam("comment_id") long comentId){
        return null;
    }
    @PatchMapping(value = "/comments", params = {"band_id","comment_id"})
    public ResponseEntity patchComment(@RequestParam("band_id") long bandId, @RequestParam("comment_id") long comentId){
        return null;
    }
}
