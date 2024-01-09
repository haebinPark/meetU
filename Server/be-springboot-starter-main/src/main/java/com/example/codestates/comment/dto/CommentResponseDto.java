package com.example.codestates.comment.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CommentResponseDto {
    private Long comentId;
    private String nickname;
    private String context;
}
