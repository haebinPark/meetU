package com.example.codestates.place.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComentConroller {
    @PostMapping(value = "/coments", params = "band_id")
    public ResponseEntity postComent(@RequestParam("band_id") long bandId){
        return null;
    }
    @GetMapping(value = "/coments", params = "band_id")
    public ResponseEntity getComent(@RequestParam("band_id") long bandId){
        return null;
    }
    @DeleteMapping(value = "/coments", params = {"band_id","coment_id"})
    public ResponseEntity deleteComent(@RequestParam("band_id") long bandId, @RequestParam("coment_id") long comentId){
        return null;
    }
    @PatchMapping(value = "/coments", params = {"band_id","coment_id"})
    public ResponseEntity patchComent(@RequestParam("band_id") long bandId, @RequestParam("coment_id") long comentId){
        return null;
    }
}
