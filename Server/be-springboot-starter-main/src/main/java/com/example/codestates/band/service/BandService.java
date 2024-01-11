package com.example.codestates.band.service;

import com.example.codestates.band.entitiy.Band;
import com.example.codestates.band.repository.BandRepository;
import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.ExceptionCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandService {
    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }


    public Optional<Band> findById(Long bandId) {
        return Optional.ofNullable(bandRepository.findById(bandId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND)));
    }
}