package com.example.codestates.member.dto;

import com.example.codestates.member.entitiy.Interesting;
import com.example.codestates.member.entitiy.Mbit;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String nickname;
        private String password;
        private String email;
        private Mbit mbti;
        private Interesting interesting;
    }
    @Getter
    public static class Patch{
        private Long memberId;
        private String nickname;
        private Mbit mbti;
        private Interesting interesting;

        public void setMemberId(Long memberId){
            this.memberId =memberId;
        }
    }
}
