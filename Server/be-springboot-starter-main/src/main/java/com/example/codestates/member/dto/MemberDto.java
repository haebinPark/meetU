package com.example.codestates.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class MemberDto {



    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long memberId;


    @Getter
    @AllArgsConstructor
    public static class Post {
        private String nickname;
        private String password;
        private String email;
        private String bgColorName;  // 사용자가 선택한 배경색의 이름
    }
    @Getter
    public static class Patch{
        private Long memberId;
        private String nickname;


        public void setMemberId(Long memberId){
            this.memberId =memberId;
        }
    }
}
