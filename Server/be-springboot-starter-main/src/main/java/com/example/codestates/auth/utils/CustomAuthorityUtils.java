package com.example.codestates.auth.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthorityUtils {
    //(1) application.yml에 추가한 프로퍼티를 가져오는 표현식
    //@Value("${mail.address.admin}>프로퍼티 경로")
    //private String adminMailAddress;

    //(2)스프링 시큐리티에서 지원하는 AuthorityUtils 클래스를 이용해서 관리자용 권한 목록을 List<GrantedAuthority> 객체로 미리 생성
    //관리자 권한의 경우 일반 사용자의 권한까지 추가로 포함
    //private final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    //(3) Spring Security에서 지원하는 AuthorityUtils 클래스를 이용해서 일반 사용 권한 목록을 List<GrantedAuthority> 객체로 미리 생성합니다.
    private final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");

    private final List<String> USER_ROLES_STRING = List.of("USER");

    public List<GrantedAuthority> createAuthorities(String email){
        //(4)파라미터로 전달 받은 이메일 주소가 yml 파일에서 가져온 관리자용 이메일 주소와 동일하다면 관리자용 권한인 ADMIN_ROLES를 리턴
        //if(email.equals(adminMailAddress)){
        // return ADMIN_ROLES;
        //}
        return USER_ROLES;
    }


    //DB에 저장된 role을 기반으로 권한 정보 생성 yml파일 필요없음
    public List<GrantedAuthority> createAuthorities(List<String> roles){
        List<GrantedAuthority> authorities =roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return authorities;
    }
    //DB에 roles를 저장하는 코드
    public String createRoles(String email){
        return "USER_ROLES_STRING";
    }
}
