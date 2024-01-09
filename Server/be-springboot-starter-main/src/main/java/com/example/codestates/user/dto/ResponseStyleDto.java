package com.example.codestates.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStyleDto {
    private Long userId;
    private String nickName;
    private String styleCode;
}
