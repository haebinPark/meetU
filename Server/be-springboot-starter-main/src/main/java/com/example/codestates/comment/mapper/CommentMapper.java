package com.example.codestates.comment.mapper;

import com.example.codestates.comment.dto.CommentDto;
import com.example.codestates.comment.dto.CommentResponseDto;
import com.example.codestates.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    Comment comentPostDtoTocoment(CommentDto.Post requestBody);
    Comment comentPatchDtoTocoment(CommentDto.Patch requestBody);

    CommentResponseDto comentToComentResponseDto(Comment comment);
}
