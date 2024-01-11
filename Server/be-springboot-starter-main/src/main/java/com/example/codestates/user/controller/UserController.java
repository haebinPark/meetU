package com.example.codestates.user.controller;

import com.example.codestates.user.dto.PatchStyleDto;
import com.example.codestates.user.dto.GetStyleDto;
import com.example.codestates.user.dto.ResponseStyleDto;
import com.example.codestates.user.entity.User;
import com.example.codestates.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users") //공용 url 설정
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{userId}") //사용자 닉네임 배경색 조회
    public ResponseEntity<GetStyleDto> getUserStyle(@PathVariable Long userId) {
        GetStyleDto getStyleDto = userService.getUserStyle(userId);  // UserService를 통해 스타일 정보를 가져옴
        return ResponseEntity.ok(getStyleDto); // 가져온 스타일 정보를 HTTP 응답으로 반환
    }

    // HTTP GET 요청을 / 경로로 매핑
    @GetMapping("/") //사용자 배경색 리스트 조회
    public Map<String, String> getUserStyles() {
        Map<String, String> colors = new HashMap<>(); //colors라는 이름의 색상 코드 저장할 리스트(HashMap)
        for (User.nickNameColor color : User.nickNameColor.values()) { //유저의 배경색 enum을 순회하며 string 변환
            colors.put(color.name(), color.getCode()); // 색상과 코드값을 colors에 저장
        }
        return colors; //모든 색상과 코드값이 저장된 리스트 colors를 반환
    }

    @PatchMapping("users/{userId}") //사용자 닉네임 배경색 수정
    public ResponseEntity<PatchStyleDto> patchUserStyle(@PathVariable Long userId,
                                                        @RequestBody PatchStyleDto patchDto) {
        ResponseStyleDto responseStyleDto = userService.updateUserStyle(userId,patchDto);//UserService를 통해 스타일 정보를 업데이트하고 결과를 반환
        return ResponseEntity.ok(responseStyleDto); // 업데이트된 스타일 정보를 HTTP 응답으로 반환
    }
}
