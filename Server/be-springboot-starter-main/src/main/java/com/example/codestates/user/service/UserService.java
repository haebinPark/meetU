package com.example.codestates.user.service;

import com.example.codestates.user.dto.GetStyleDto;
import com.example.codestates.user.entity.User;
import com.example.codestates.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetStyleDto getStyleDto(Long userId) {
        User user = userRepository.findById(userId)
    }
}
