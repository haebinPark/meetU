package com.example.codestates.band.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class BandController {
    @PostMapping
    public ResponseEntity postBand(){
        return null;
    }
    @GetMapping
    public ResponseEntity getBands(){
        return null;
    }
    @GetMapping
    public ResponseEntity getBand(){
        return null;
    }
    @PatchMapping
    public ResponseEntity updateBand(){
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteBand(){
        return null;
    }
}
