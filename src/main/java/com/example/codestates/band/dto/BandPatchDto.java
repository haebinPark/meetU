package com.example.codestates.band.dto;

import com.example.codestates.band.entity.Band;
import lombok.Getter;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class BandPatchDto {


    private long BandId;

    @NotBlank
    //@Pattern()
    private String school;//학교명 코드 초등학교라면 코드만 입력함. 초등학교는 밑 schoolcode에서 받아옴.

    @NotBlank
    private String schoolcode;//학교코드 초등학교, 중학교, 고등학교
    @NonNull
    @Range(min=1, max = 6)
    private int grade; //학년 초등학교 선택시 1~6까지만.7이상 불가. 중고등학교 선택시 1~3학년까지만 4이상불가.

    @NonNull
    @Range(min=1, max = 99) // 1~99반까지 생성가능.
    private int bannum;//반

    @NotBlank
    //@Pattern() 현재 미설정
    private String joinpass; //반 가입 신청시 비밀번호

    private Band.statusUpdate statusUpdate;

    public void setBandId(long bandId) {this.BandId = bandId;}

}
