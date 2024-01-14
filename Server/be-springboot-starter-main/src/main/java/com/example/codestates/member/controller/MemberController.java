package com.example.codestates.member.controller;

import com.example.codestates.member.dto.MemberPatchDto;
import com.example.codestates.member.dto.MemberResponseDto;
import com.example.codestates.member.entity.Member;
import com.example.codestates.member.mapper.MemberMapper;
import com.example.codestates.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users") //공용 url 설정
public class MemberController { //mapper로 엔티티 -> dto변경 반환

    private MemberService memberService;
    private MemberMapper memberMapper;

    public MemberController(MemberService memberService,MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }


    //회원의 내 정보 조회(배경색 포함)
    @GetMapping("/users{userId}")
    public ResponseEntity getMemberStyle(@PathVariable Long userId) {
        Member member = memberService.findMember(userId);
        MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);
        return ResponseEntity.ok(memberResponseDto);
    }

    @PatchMapping("users/{userId}") ////회원 내 정보 수정(배경색 수정)v
    public ResponseEntity patchUserStyle(@PathVariable Long userId,
                                         @RequestBody MemberPatchDto memberPatchDtopatchDto) {
        // 클라이언트로부터 받아온 스타일 코드 정보를 이용하여 회원의 스타일 코드를 업데이트
        Member member = memberService.updateUserStyle(userId, Member.NickNameColor.valueOf(memberPatchDtopatchDto.getStyleCode()));
        // 업데이트된 회원 정보를 MemberResponseDto로 변환
        MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);
        // 업데이트된 회원 정보를 클라이언트에게 반환
        return ResponseEntity.ok(memberResponseDto);
    }

    // HTTP GET 요청을 / 경로로 매핑
    @GetMapping("/") //사용자 배경색 리스트 조회
    public ResponseEntity getMemberStyles() {

        return null;
        }

    }

//사용자 닉네임 색 조회 => 유저 정보 조회에서 가져올 수 있어서 필요x, 사용하려면 메퍼사용 및 수정 필요
//    @GetMapping("users/{userId}") //사용자 닉네임 배경색 조회
//    public ResponseEntity<GetStyleDto> getUserStyle(@PathVariable Long userId) {
//        GetStyleDto getStyleDto = userService.getUserStyle(userId);  // UserService를 통해 스타일 정보를 가져옴
//        return ResponseEntity.ok(getStyleDto); // 가져온 스타일 정보를 HTTP 응답으로 반환
//    }




}
