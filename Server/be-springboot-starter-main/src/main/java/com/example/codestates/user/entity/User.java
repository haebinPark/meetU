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
@Table(name="UERS")
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
    @Column(nullable = false)
    private nickNameColor styleCode = nickNameColor.BROWN; //닉네임 배경색 enum 타입, 기본 갈색

    public enum nickNameColor { // 프론트 {"RED": "#faebdd"..다른색:값} 형식으로 줘야함
        BROWN("#f4eeee"), //갈색
        ORANGE("#faebdd"), //주황
        YELLOW("#fbf3db"), //노랑
        GREEN("#edf3ec"), //녹색
        BLUE("#e7f3f8"), //파랑
        PURPLE("#f6f3f9"), //보라
        PINK("#faf1f5"), //분홍
        RED("#fdebec"); // 빨간

        private final String code;

        nickNameColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }
}
