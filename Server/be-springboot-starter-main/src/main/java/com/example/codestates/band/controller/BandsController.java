package com.example.codestates.band.controller;

import com.example.codestates.band.dto.PostDto;
import com.example.codestates.band.dto.ResponseDto;
import com.example.codestates.band.entity.Bands;
import com.example.codestates.band.mapper.BandsMapper;
import com.example.codestates.band.service.BandsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/Bands")
@RestController
public class BandsController {

    private final BandsService bandsService;
    private final BandsMapper bandsMapper;

    public BandsController(BandsService bandsService, BandsMapper bandsMapper) {
        this.bandsService = bandsService;
        this.bandsMapper = bandsMapper;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> postBands(@Valid @RequestBody PostDto postDto) {
        Bands bands =
                bandsService.createProducts(bandsMapper.productsDtoToProducts(postDto));

        return ResponseEntity.ok(bandsMapper.productsToResponseDto(bands));
    }


}