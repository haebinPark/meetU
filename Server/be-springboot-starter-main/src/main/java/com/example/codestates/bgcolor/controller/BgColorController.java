package com.example.codestates.bgcolor.controller;

import com.example.codestates.bgcolor.dto.BgColorResponseDto;
import com.example.codestates.bgcolor.dto.BgColorPostDto;
import com.example.codestates.bgcolor.entity.BgColor;
import com.example.codestates.bgcolor.mapper.BgColorMapper;
import com.example.codestates.bgcolor.service.BgColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colors")
public class BgColorController {

    private final BgColorService bgColorService;
    private final BgColorMapper mapper;

    public BgColorController(BgColorService bgColorService, BgColorMapper mapper) {
        this.bgColorService = bgColorService;
        this.mapper = mapper;
    }

    // 배경색 데이터를 저장하는 메소드입니다.
    // 이 메소드는 "/bgColors" 경로로 들어오는 POST 요청을 처리합니다.
    @PostMapping
    public ResponseEntity postBgColor(@RequestBody BgColorPostDto bgColorPostDto) {
        // dto를 BgColor 엔티티로 변환합니다.
        BgColor newBgColor = mapper.bgColorPostDtoToBgColor(bgColorPostDto);
        // 변환된 BgColor 엔티티를 저장하고, 그 결과를 postedBgColor에 저장
        BgColor postedBgColor = bgColorService.saveBgColor(newBgColor);
        // savedBgColor를 BgColorDtoResponseDto로 변환하여 반환
        return ResponseEntity.ok(mapper.bgColorToBgColorDtoResponseDto(postedBgColor));
    }

    // 전체 배경색을 조회하는 메소드입니다.
    // 이 메소드는 "/bgColors" 경로로 들어오는 GET 요청을 처리합니다.
    @GetMapping
    public ResponseEntity getAllBgColors(@RequestBody BgColorResponseDto bgColorResponseDto) {
        // 모든 배경색을 조회하고, 그 결과를 colors에 저장합니다.
        List<BgColor> colors = bgColorService.getAllBgColors();
        // colors의 각 요소를 BgColorDtoResponseDto로 변환하고, 그 결과를 dtoList에 저장
        List<BgColorResponseDto> dtoList = colors.stream()
                .map(mapper::bgColorToBgColorDtoResponseDto)
                .collect(Collectors.toList());
        // dtoList를 반환합니다.
        return ResponseEntity.ok(dtoList);
    }
}
