package com.example.codestates.bgcolor.mapper;

import com.example.codestates.bgcolor.dto.BgColorResponseDto;
import com.example.codestates.bgcolor.dto.BgColorPostDto;
import com.example.codestates.bgcolor.entity.BgColor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // MapStruct의 Mapper임을 나타냅니다. 이 Mapper는 Spring Bean으로 등록
public interface BgColorMapper {
    BgColor bgColorPostDtoToBgColor(BgColorPostDto dto); // BgColorPostDto를 BgColor 엔티티로 변환하는 메소드
    BgColorResponseDto bgColorToBgColorDtoResponseDto(BgColor bgColor); // BgColor 엔티티를 BgColorDtoResponseDto로 변환하는 메소드
}
