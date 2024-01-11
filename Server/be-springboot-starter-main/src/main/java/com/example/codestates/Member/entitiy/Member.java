package com.example.codestates.Member.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false,unique = true, length = 10)
    private String nickname;
    @Column(length = 10)
    private String password;
    @Column(nullable = false,updatable = false, unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Mbit mbti;

    @Enumerated(value = EnumType.STRING)
    private Interesting interesting;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NickNameColor styleCode = NickNameColor.WHITE; //닉네임 배경색 enum 타입



}
