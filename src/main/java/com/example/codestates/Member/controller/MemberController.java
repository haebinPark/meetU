package com.example.codestates.Member.controller;

import com.example.codestates.Member.dto.MemberDto;
import com.example.codestates.Member.entity.Member;
import com.example.codestates.Member.mapper.MemberMapper;
import com.example.codestates.Member.service.MemberService;
import com.example.codestates.response.MultiResponseDto;
import com.example.codestates.response.SingleResponseDto;
import com.example.codestates.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/members") // 경로를 "/users"에서 "/members"로 변경
@Slf4j

public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/members"; // 경로 변경

    private final MemberService memberService;

    private final MemberMapper mapper;

    // *코멘트 쓰게되면?* private final CommentMapper commentMapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
        // *코멘트 쓰게되면?* this.commentMapper = commentMapper;
    }

    // 회원가입 처리
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody){
        Member member = mapper.memberPostDtoToMember(requestBody); // 정보 입력 받음
        Member createdMember = memberService.createMember(member); //새로은 member 생성

        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId()); //생성된 회원의 URI 응답으로 반환

        return ResponseEntity.created(location).build();
    }

    // MBTI 기준
    @GetMapping(params = {"mbtitype"})
    public ResponseEntity getMbtiMembers(@RequestParam("mbtitype") String mbtitype,
                                         @Positive @RequestParam int page,
                                         @Positive @RequestParam int size){
        Page<Member> pageMbtiMembers = memberService.findMembersByMbti(mbtitype, page-1, size);
        List<Member> mbtiMembers = pageMbtiMembers.getContent();

        return ResponseEntity.ok(new MultiResponseDto<>(mapper.membersToMemberResponseDtos(mbtiMembers), pageMbtiMembers));
    }
// 관심사 기준
    @GetMapping(params = {"interestingtype"})
    public ResponseEntity getInterestingMembers(@RequestParam("interestingtype") String interestingtype,
        @Positive @RequestParam int page,
        @Positive @RequestParam int size){
        Page<Member> pageInterestingMembers = memberService.findMembersByInterest(interestingtype, page-1, size);
        List<Member> interestingMembers = pageInterestingMembers.getContent();

        return ResponseEntity.ok(new MultiResponseDto<>(mapper.membersToMemberResponseDtos(interestingMembers), pageInterestingMembers));
    }

// 회원 정보 수정
    @PatchMapping(value = "/{member_id}")
    public ResponseEntity patchMember(@PathVariable("member_id") @Positive long memberId,
    @Valid @RequestBody MemberDto.Patch requestBody){
    requestBody.setMemberId(memberId);
    Member member = memberService.updateMember(mapper.memberPatchDtoToMember(requestBody));

    return ResponseEntity.ok(new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)));
    }

// 회원 삭제
    @DeleteMapping(value = "/{member_id}")
    public ResponseEntity deleteMember(@PathVariable("member_id") @Positive long memberId){
    memberService.deleteMember(memberId);

    return ResponseEntity.noContent().build();
    }