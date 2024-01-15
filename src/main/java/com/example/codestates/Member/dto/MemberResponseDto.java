package com.example.codestates.Member.dto;

//import com.example.codestates.Member.entitiy.Interesting;
//import com.example.codestates.Member.entitiy.Mbit;
//import com.example.codestates.Member.entitiy.NickNameColor;
//
//public class MemberResponseDto {
//    private Long memberId;
//    private String nickname;
//    private Mbit mbti;
//    private Interesting interesting;
//    private NickNameColor styleCode;
//
//}

// 엔티티의 직접적인 참조 피하는 새로운 코드 수정

public class MemberResponseDto {
    private Long memberId;
    private String nickname;
    private String mbtiType; // MBTI 타입을 String으로 변경
    private String interestingName; // 관심사 이름을 String으로 변경
    private String styleCode; // styleCode를 String 형식으로 변경

    // 생성자, getter, setter 생략
}
