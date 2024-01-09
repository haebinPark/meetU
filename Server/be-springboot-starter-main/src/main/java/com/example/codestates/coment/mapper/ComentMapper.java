package com.example.codestates.coment.mapper;

import com.example.codestates.coment.dto.ComentDto;
import com.example.codestates.coment.dto.ComentResponseDto;
import com.example.codestates.coment.entity.Coment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComentMapper {
    Coment comentPostDtoTocoment(ComentDto.Post requestBody);
    Coment comentPatchDtoTocoment(ComentDto.Patch requestBody);

    ComentResponseDto comentToComentResponseDto(Coment coment);
}
