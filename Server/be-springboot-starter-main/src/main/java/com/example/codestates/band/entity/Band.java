package com.example.codestates.band.entity;

import com.example.codestates.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Band extends Auditable {

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

    @Transient
    private String gradeAndBannum;

    @Column(length = 300, nullable = false)
    private String joinpass; // 반 가입 신청에 관련한 비밀번호

    @Column(length = 100, nullable = false)
    private String username; // 신청자 성명


    //반 신청 상태에 대한 코드
    @Enumerated(value = EnumType.STRING)
    @Column(length = 200, nullable = false)
    private StatusUpdate statusUpdate = StatusUpdate.ApplicationCompleted; //기본값으로 신청완료를 나타냄.


    public enum StatusUpdate  {

        ApplicationCompleted("신청완료"), //신청완료
        ApplicationPending("개설중"), //개설중
        SignUp("가입하기"); // 가입하기

        @Getter
        private String status;

        StatusUpdate(String status) {
            this.status = status;
        }


    }



}
