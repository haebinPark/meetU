package com.example.codestates.band.entitiy;

import com.example.codestates.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Band {


    @Id //엔티티의 기본키임을 명시함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키의 자동생성을 지정하는 어노베이션.
    private Long bandId;


    @Column(length = 100, nullable = false)
    private String school; //학교명

    @Column(length = 100, nullable = false)
    private String schoolcode; //학교등급

    @Column(nullable = false)
    private int grade; //학년

    @Column(nullable = false)
    private int bannum; //반

    @Column(length = 300, nullable = false)
    private String pagepass; // 반 생성 신청에 관련한 비밀번호

    @Column(length = 100, nullable = false)
    private String username; // 신청자 성명


    //반 신청상태에 대한 코드
    @Enumerated(value = EnumType.STRING)
    @Column(length = 100, nullable = false)
    private StatusUpdate status = StatusUpdate.ApplicationCompleted; //기본값으로 신청완료를 나타냄.

    @OneToMany(mappedBy = "band")
    private List<Comment> comments = new ArrayList<>();

}