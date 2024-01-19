//package com.example.codestates.auth.provider;
//
//import com.example.codestates.auth.userdetails.MemberDetailsService;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Optional;
//
//@Component
//public class MemberAuthenticationProvider implements AuthenticationProvider {//AuthenticationProvider인터페이스의 구현 클래스로 정의
//    //스프링 시큐리티는 AuthenticationProvider를 구현한 구현 클래스가 스피링 bean으로 등록되어 있다면 해당 authenticationProvider를 이용해서 인증을 진행
//
//    private  final MemberDetailsService memberDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    public MemberAuthenticationProvider(MemberDetailsService memberDetailsService, PasswordEncoder passwordEncoder) {
//        this.memberDetailsService = memberDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    //우리가 직접 작성한 인증 처리 로직을 이용해서 사용자의 인증 여부를 결정
//@Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
//        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
//        //authentication을 캐스팅 하여 UsernamePAsswordAuthenticationToken을 얻는다
//
//        String username = authToken.getName();
//        //UPAT 객체에서 사용자의 username을 얻은 후
//
//        Optional.ofNullable(username).orElseThrow(()-> new UsernameNotFoundException("Invaild User name or User Password"));
//        //존재하는지 체크한다
//    try {
//        UserDetails userDetails = memberDetailsService.loadUserByUsername(username);
//        //존재 한다면 데이터 베이스에서 해당 사용자를 조회한다
//
//        String password = userDetails.getPassword();
//        verifyCredentials(authToken.getCredentials(), password);
//        //로그인 정보에 포함된 패스워드(AuthToken.getCredentials())와 데이터베이스에 저장된 사용자의 패스워드 정보가 일치하는지를 검증한다
//        //검증 통과 시
//
//        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        //해당 사용자의 권한을 생성
//        return UsernamePasswordAuthenticationToken.authenticated(username, password, authorities);
//        //인증된 사용자의 인증 정보를 리턴 값으로 전달
//    } catch (Exception ex){
//        throw  new UsernameNotFoundException(ex.getMessage());
//        //AuthenticationException이 아닌 다른 Exception이 발생할 경우 다시 AuthenticationException으로 다시 rethrow하도록 개선
//        //다른 exception이 발생할 경우 꼭!! rethrow하도록 구성해야함
//
//    }
//
//    /*
//     Custom AuthenticationProvider를 이용할 경우에는 회원가입 전 인증 실패 시, 왜 [그림 4-11-2]와 같은 화면이 표시되지 않고 [그림 4-11-1]과 같은 “Whitelebel Error Page”가 표시되는 걸까요?
//      이유는 MemberService에서 등록된 회원 정보가 없으면, BusinessLogicException을 throw 하는데 이 BusinessLogicException이 Cusotm AuthenticationProvider를 거쳐 그대로 Spring Security 내부 영역으로 throw 되기 때문
//     */
//    }
//
//    //구현하는 Custom AuthenticationProvider가 Username/Password방식의 인증을 지원한다는 것을 스프링 시큐리티에 알려주는 역할
//    //리턴값이 true 일경우, 시큐리티는 해당 authenticationProvider의 authenticate()메서드를 호출해서 인증을 진행
//    public boolean supports(Class<?> authentication){
//        return  UsernamePasswordAuthenticationToken.class.equals(authentication);
//    }
//    private void verifyCredentials(Object credentials, String password){
//        if(!passwordEncoder.matches((String)credentials,password)){
//            throw  new BadCredentialsException("Invaild User name or User Password");
//        }
//    }
//}
