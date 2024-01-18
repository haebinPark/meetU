package com.example.codestates.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auths")
public class AuthController {

    //로그인 버튼을 눌렀을 때 실행되는 post
    @PostMapping
    public String login(){
        System.out.println("login");
        return null;
    }
}
