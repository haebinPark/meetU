package com.example.codestates.band.dto;


import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
public class BandostDto {

    @NotBlank
    private String school;//학교명

    @NotBlank
    private String schoolcode;//학교코드 1. 초등학교 2.중학교 3.고등학교

    @NotBlank
    private int grade; //학년 초등학교 선택시 1~6까지만.7이상 불가. 중고등학교 선택시 1~3학년까지만 4이상불가.

    @Range(min=1, max = 15) // 1~15반까지 생성가능.
    private int bannum;//반

    @NotBlank
    //@Pattern() 현재 미설정
    private String joinpass; //반 가입 신청시 비밀번호

    private String username; // 신청자 성명

}
