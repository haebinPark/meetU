package com.example.codestates.band.dto;


import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
public class PostDto {

    @NotBlank
    private String school;//학교명
    private String schoolcode;//학교코드 1. 초등학교 2.중학교 3.고등학교
    private int grade; //학년 초등학교 선택시 1~6까지만.7이상 불가. 중고등학교 선택시 1~3학년까지만 4이상불가.
    private int bannum;//반
    private String pagepass; //반 생성 신청 비밀번호
    private String joinpass; //반 가입 신청시 비밀번호
    private String username; // 신청자 성명..근데 이걸 직접입력? 회원정보에서 땡겨오는건 안되나..?

}
