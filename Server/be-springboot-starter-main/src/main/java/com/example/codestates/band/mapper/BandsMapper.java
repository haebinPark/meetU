package com.example.codestates.band.mapper;


import com.example.codestates.band.entity.Bands;
import com.example.codestates.band.dto.PostDto;
import com.example.codestates.band.dto.ResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BandsMapper {


    Bands productsDtoToProducts(PostDto postDto);

    ResponseDto productsToResponseDto(Bands bands);
}
