package com.example.codestates.Member.controller;

import com.example.codestates.Member.mapper.MemberMapper;
import com.example.codestates.Member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class MemberController {
    private final static String USER_DEFAULT_URL = "/users";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }
}
