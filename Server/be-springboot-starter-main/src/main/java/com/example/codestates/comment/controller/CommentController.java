package com.example.codestates.comment.controller;

import com.example.codestates.comment.dto.CommentDto;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.mapper.CommentMapper;
import com.example.codestates.comment.repository.CommentRepository;
import com.example.codestates.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

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
    public ResponseEntity getComment(@RequestParam("band_id") long bandId,
                                     @Positive @RequestParam int page,
                                     @Positive @RequestParam int size){
        Page<Comment> foundComment = commentService.findAll(page,size);
        List<Comment> comments = pageComment.getContent();
        return ResponseEntity.ok(new MultiResponseDto(mapper.commentsToCommentResponseDtos(comments),pageComment))
    }
    @DeleteMapping(params = {"band_id"},value = "/{comment_id}")
    public ResponseEntity deleteComment(@RequestParam("band_id") long bandId, @PathVariable("comment_id") long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(params = {"band_id","comment_id"})
    public ResponseEntity patchComment(@RequestParam("band_id") long bandId,
                                       @RequestParam("comment_id") long commentId,
                                      @RequestBody CommentDto.Patch requestBody ){
        requestBody.addCommentId(commentId);
        Comment updateComment = commentService.updateComment(mapper.commentPatchDtoTocomment(requestBody));

        return ResponseEntity.ok(mapper.commentToCommentResponseDto(updateComment));
    }
}
