package com.example.codestates.member.entity;

import com.example.codestates.band.entity.Band;
import com.example.codestates.mbti.entity.Mbti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 6, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    // (2) 추가
//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> roles = new ArrayList<>();

    private String role = "USER";

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "bgcolor_id")
    private BgColor bgColor;    //닉네임 배경색

    @ManyToOne
    private Mbti mbti;
}
