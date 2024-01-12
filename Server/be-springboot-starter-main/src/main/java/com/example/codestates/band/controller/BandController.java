package com.example.codestates.band.controller;

import com.example.codestates.band.dto.BandPostDto;
import com.example.codestates.band.entity.Band;
import com.example.codestates.band.mapper.BandMapper;
import com.example.codestates.band.service.BandService;
import com.example.codestates.band.utils.UriCreator;
import com.example.codestates.dto.MultiResponseDto;
import com.example.codestates.dto.SingleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RequestMapping("/bands")
@RestController
@Validated
public class BandController {

    private final static String BAND_DEFAULT_URL = "/bands";

    private final BandService bandService;
    private final BandMapper bandMapper;

    public BandController(BandService bandService, BandMapper bandMapper) {
        this.bandService = bandService;
        this.bandMapper = bandMapper;
    }

    //생성관련



   @PostMapping
  public ResponseEntity postBands(@Valid @RequestBody BandPostDto bandPostDto) {
        Band band = bandService.createBand(bandMapper.bandPostDtoToBand(bandPostDto));
        URI location = UriCreator.createUri(BAND_DEFAULT_URL, band.getBandId());

        return ResponseEntity.created(location).build();

   }
    //Valid로 유효성 검사 @RequestBody로 요청데이터를 POSTDTO 객체로 매핑함.
    // createBands 매서드는 coffeePostDto를 입력받아 실제 객체를 생성하고 데이터베이스에 저장하는 로직임.

//수정관련
    //@PatchMapping
    // public ResponseEntity patchBands{
        //기능 구현 아니함.
    //}


    //조회관련
   /* @GetMapping("/{band-id}")
    public ResponseEntity getBand(@PathVariable("band-id")long bandId){

        Band band = bandService.findBand(bandId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(bandMapper.bandToBandResponseDto(band)),
                HttpStatus.OK);

    } */

    @GetMapping("/{band-id}")
    public ResponseEntity getBand(@PathVariable("band-id")String school){

        Band band = bandService.findBand(school);

        return new ResponseEntity<>(
                new SingleResponseDto<>(bandMapper.bandToBandResponseDto(band)),
                HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity getBands(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size){
        // @Positive @RequestParam int page 페이지번호 1이상의 양수값이어야함.
        // @Positive @RequestParam int size 페이지크키 1이상의 양수값이어야함.

        Page<Band> pageBands = bandService.findBands(page -1, size);
        List<Band> bands = pageBands.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(bandMapper.bandToBandResponseDtos(bands), pageBands), HttpStatus.OK);


    }

    //삭제관련
    @DeleteMapping("/bands/{band-id}")
    public ResponseEntity deleteBand(@PathVariable("band-id") long bandId){
        bandService.deleteBands(bandId);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }




}