package com.example.codestates.coment.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ComentResponseDto {
    private Long comentId;
    private String nickname;
    private String context;
}
