package com.example.codestates.band.entitiy;

import lombok.Getter;

public enum StatusUpdate {


    ApplicationCompleted("신청완료"), //신청완료
    ApplicationPending("개설중"), //개설중
    SignUp("가입하기"); // 가입하기

    @Getter
    private String status;

    StatusUpdate(String status) {
        this.status = status;
    }
}
