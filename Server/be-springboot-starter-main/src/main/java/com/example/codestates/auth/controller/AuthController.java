//package com.example.codestates.auth.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.PublicKey;
//
////로그인 인증을 위한 AuthController
//@Controller
//@RequestMapping("/auths")
//public class AuthController {
//    @GetMapping ("/login-form")
//    public String loginForm(){
//        return "login";
//    }
//
//    @GetMapping("/access-denied")
//    public String accessDenied(){
//        return "access-denied";
//    }
//
//    /* 로그인 폼에서 로그인 버튼 클릭시 login핸들러 메서드로 요청 전송
//    * */
//    @PostMapping("/login")
//    public String login(){
//        System.out.println("Login successfully!");
//
//        return "home";
//    }
//}
