package com.example.codestates.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 6, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String passWord;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column()
    private nickNameColor styleCode; //닉네임 배경색 enum 타입

    public enum nickNameColor {
        WHITE("#FFFFFF"), //흰색
        RED("#FF0000"), // 빨간색
        GREEN("#00FF00"), // 녹색
        BLUE("#0000FF"), // 파란색
        YELLOW("#FFFF00"), // 노란색
        PURPLE("#FF00FF"), // 보라색
        CYAN("#00FFFF"), // 청록색
        BLACK("#000000"); // 검정색

        private final String code;

        nickNameColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }
}
