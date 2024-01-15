package com.example.codestates.Member.dto;

import com.example.codestates.Member.entitiy.Interesting;
import com.example.codestates.Member.entitiy.Mbit;
import com.example.codestates.Member.entitiy.NickNameColor;

public class MemberResponseDto {
    private Long memberId;
    private String nickname;
    private String mbtiType; // MBTI 타입을 String으로 변경
    private String interestingName; // 관심사 이름을 String으로 변경
    private String styleCode; // styleCode를 String 형식으로 변경

}
