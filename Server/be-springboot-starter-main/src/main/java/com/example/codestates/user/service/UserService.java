package com.example.codestates.user.service;

import com.example.codestates.user.dto.GetStyleDto;
import com.example.codestates.user.dto.PatchStyleDto;
import com.example.codestates.user.dto.ResponseStyleDto;
import com.example.codestates.user.entity.User;
import com.example.codestates.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetStyleDto getUserStyle(Long userId) { //사용자 스타일 정보 조회
        User findUser = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found")); //찾을수 없는 경우 예외 발생
        return new GetStyleDto(findUser.getUserId(),findUser.getNickName(),findUser.getStyleCode().toString()); //찾은 정보로 GetStyleDto 생성 반환
    }

    public ResponseStyleDto updateUserStyle(Long userId, PatchStyleDto patchStyleDto) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
        findUser.setStyleCode(User.nickNameColor.valueOf(patchStyleDto.getStyleCode().toUpperCase()));//enum->String변환,대문자로 변환 닉네임 색상을 업데이트
        User updatedUser = userRepository.save(findUser); //변경된 사용자 정보 저장
        return new ResponseStyleDto(updatedUser.getUserId(),updatedUser.getNickName(),updatedUser.getStyleCode().name());
                // 업데이트된 정보를 바탕으로 ResponseStyleDto 객체를 생성 반환
    }
}
