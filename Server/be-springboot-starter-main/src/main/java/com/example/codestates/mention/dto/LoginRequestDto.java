package com.example.codestates.mention.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LoginRequestDto {
    private Long id;
    private String nickname;
    private String password;
}