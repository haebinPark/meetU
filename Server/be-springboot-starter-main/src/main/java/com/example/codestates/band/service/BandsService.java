package com.example.codestates.band.service;


import com.example.codestates.band.entity.Bands;
import com.example.codestates.band.entity.BandsRepository;
import org.springframework.stereotype.Service;

@Service
public class BandsService {

    private final BandsRepository bandsRepository;

    public BandsService(BandsRepository bandsRepository){

        this.bandsRepository = bandsRepository;
    }

    public Bands createProducts(Bands bands){

        return bandsRepository.save(bands);

    }


}
