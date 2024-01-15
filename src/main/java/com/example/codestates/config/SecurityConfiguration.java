package com.example.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SecurityConfiguration {

    @bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .headers().frameOptions().sameOrigin()
                //H2 웹 콘솔을 정상적으로 사용할 수 있도록 frameOptions().sameOrigin() 을 추가합니다.
                .and()
                .csrf().disable()
                //CSRF(Cross-Site Request Forgery) 공격에 대한 Spring Security에 대한 설정을 비활성화합니다.
                //로컬 환경에서 Spring Security에 대한 학습을 진행하므로, CSRF 공격에 대한 설정이 필요하지 않습니다.
                .cors(Customizer.withDefaults())
                //cors(withDefaults()) 일 경우, corsConfigurationSource라는 이름으로 등록된 Bean을 이용합니다.
                //CORS를 처리하는 가장 쉬운 방법은 CorsFilter를 사용하는 것인데 CorsConfigurationSource Bean을 제공함으로써 CorsFilter를 적용할 수 있습니다.
                .formLogin().disable()
                //로그인방식 SSR ->JSON 포맷으로 유저이름과 패스워드를 전송
                .httpBasic().disable()
                //HTTP Basic 인증은 request를 전송할 때마다 Username/Password 정보를 HTTP Header에 실어서 인증을 하는 방식으로
                // 우리 코스에서는 사용하지 않으므로 (5)와 같이 HTTP Basic 인증 방식을 비활성화합니다.
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()); //WT를 적용하기 전이므로 우선은 모든 HTTP request 요청에 대해서 접근을 허용하도록 설정


        return http.build();

    }//SecurityFilterChain filterChain


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //PasswordEncoder Bean 객체를 생성합니다.
    }

    //CorsConfigurationSource Bean 생성을 통해 구체적인 CORS 정책을 설정합니다.
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        //setAllowedOrigins()을 통해 모든 출처(Origin)에 대해 스크립트 기반의 HTTP 통신을 허용하도록 설정합니다.
        //이 설정은 운영 서버 환경에서 요구사항에 맞게 변경이 가능합니다.
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PATCH", "DELETE"));
        //setAllowedMethods()를 통해 파라미터로 지정한 HTTP Method에 대한 HTTP 통신을 허용합니다.

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // CorsConfigurationSource 인터페이스의 구현 클래스인 UrlBasedCorsConfigurationSource 클래스의 객체를 생성합니다.
        source.registerCorsConfiguration("\/**",configuration);
        // 모든 URL에 앞에서 구성한 CORS 정책(CorsConfiguration)을 적용합니다.


        return source;
    }
}
