package com.example.codestates.bgcolor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BgColorPostDto {
    private String colorName; // 색상의 이름을 저장하는 필드입니다.
    private String hexCode; // 색상의 Hex 코드를 저장하는 필드입니다.
}
