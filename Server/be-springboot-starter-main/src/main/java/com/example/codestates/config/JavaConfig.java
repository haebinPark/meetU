//package com.example.codestates.config;
//
//import com.example.codestates.member.DBMemberService;
//import com.example.codestates.member.repository.MemberRepository;
//import com.example.codestates.member.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class JavaConfig {
//    @Bean
//    public MemberService dbMemberService(MemberRepository memberRepository,
//                                         PasswordEncoder passwordEncoder){
//        return new DBMemberService(memberRepository,passwordEncoder);
//        //내부에서 데이터를 데이터베이스에 저장하고, 패스워드를 암호화해야함으로 memberrepository와 password encoder 객체를 DI
//
//    }
//}
