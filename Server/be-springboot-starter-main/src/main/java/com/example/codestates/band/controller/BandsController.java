package com.example.codestates.band.controller;

import com.example.codestates.band.dto.BandPostDto;
import com.example.codestates.band.entity.Band;
import com.example.codestates.band.mapper.BandsMapper;
import com.example.codestates.band.service.BandsService;
import com.example.codestates.band.utils.UriCreator;
import com.example.codestates.dto.MultiResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RequestMapping("/bands")
@RestController
public class BandsController {

    private final static String BAND_DEFAULT_URL = "/bands";

    private final BandsService bandsService;
    private final BandsMapper bandsMapper;

    public BandsController(BandsService bandsService, BandsMapper bandsMapper) {
        this.bandsService = bandsService;
        this.bandsMapper = bandsMapper;
    }

    //생성관련
    @PostMapping
    public ResponseEntity postBands(@Valid @RequestBody BandPostDto bandPostDto) {
        Band band = bandsService.createBands(bandsMapper.bandPostDtoToBand(bandPostDto));
        URI location = UriCreator.createUri(BAND_DEFAULT_URL, band.getBandId());

        return ResponseEntity.created(location).build();

    }

    //수정관련
    //@PatchMapping
    // public ResponseEntity patchBands{
        //기능 구현 아니함.
    //}


    //조회관련
    @GetMapping
    public ResponseEntity getBands(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size){
        // @Positive @RequestParam int page 페이지번호 1이상의 양수값이어야함.
        // @Positive @RequestParam int size 페이지크키 1이상의 양수값이어야함.

        Page<Band> pageBands = bandsService.findBands(page -1, size);
        List<Band> bands = pageBands.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(bandsMapper.bandToBandResponseDtos(bands), pageBands), HttpStatus.OK);


    }

    @DeleteMapping("/bands/{band-id}")
    public ResponseEntity deleteBand(@PathVariable("band-id") long bandId){
        bandsService.deleteBands(bandId);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }




}