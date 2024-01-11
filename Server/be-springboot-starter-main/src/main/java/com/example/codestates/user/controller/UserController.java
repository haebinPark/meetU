package com.example.codestates.user.controller;

import com.example.codestates.user.mapper.UserMapper;
import com.example.codestates.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final static String USER_DEFAULT_URL = "/users";
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postUser(){
        return null;
    }
    @GetMapping
    public ResponseEntity getUser(){
        return null;
    }
    @GetMapping
    public ResponseEntity getMbtiUser(){
        return null;
    }
    @GetMapping
    public ResponseEntity getInterestingUser(){
        return null;
    }
    @PatchMapping
    public ResponseEntity updateUser(){
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteUser(){
        return null;
    }
}
