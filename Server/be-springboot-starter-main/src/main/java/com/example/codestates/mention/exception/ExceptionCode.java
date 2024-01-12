package com.example.codestates.mention.exception;

import lombok.Getter;

public enum ExceptionCode {
    MENTION_NOT_FOUND(404, "Mention Not Found");


    @Getter
    private int status;

    @Getter
    private String mention;

    ExceptionCode(int status, String mention) {
        this.status = status;
        this.mention = mention;
    }
}