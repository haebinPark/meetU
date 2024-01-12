package com.example.codestates.Member.dto;

import com.example.codestates.Member.entitiy.Interesting;
import com.example.codestates.Member.entitiy.Mbit;
import com.example.codestates.Member.entitiy.NickNameColor;

public class MemberResponseDto {
    private Long memberId;
    private String nickname;
    private Mbit mbti;
    private Interesting interesting;
    private NickNameColor styleCode;

}
