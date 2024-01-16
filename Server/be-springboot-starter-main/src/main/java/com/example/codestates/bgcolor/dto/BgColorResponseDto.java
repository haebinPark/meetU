package com.example.codestates.bgcolor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BgColorResponseDto {
    private Long id; // Primary Key 필드입니다.
    private String colorName; // 색상의 이름을 저장하는 필드입니다.
    private String hexCode; // 색상의 Hex 코드를 저장하는 필드입니다.
}
