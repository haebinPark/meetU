package com.example.codestates.Member.dto;

import com.example.codestates.Member.entitiy.Interesting;
import com.example.codestates.Member.entitiy.Mbit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

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
