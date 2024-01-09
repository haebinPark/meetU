package com.example.codestates.user.controller;

import com.example.codestates.user.dto.PatchStyleDto;
import com.example.codestates.user.dto.GetStyleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("users/{userId}")
    public ResponseEntity<GetStyleDto> GetUserStyle() {
        return null;
    }

    @PatchMapping("users/{userId}")
    public ResponseEntity<PatchStyleDto> patchUserStyle() {
        return null;
    }
}
