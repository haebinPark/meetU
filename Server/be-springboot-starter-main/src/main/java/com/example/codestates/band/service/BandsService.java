package com.example.codestates.band.service;


import com.example.codestates.band.entity.Band;
import com.example.codestates.band.repository.BandsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandsService {

    private final BandsRepository bandsRepository;

    public BandsService(BandsRepository bandsRepository){this.bandsRepository = bandsRepository;}

    //생성관련
    public Band createBands(Band band){

        //이미 등록된건지 확인하는 기능 구현시(미정)
        return bandsRepository.save(band);

    }

    //조회관련
    //public Band findBand(long bandId) { return findVerifiedBandByQuery(bandId); }

    public Page<Band> findBands(int page, int size){
        return bandsRepository.findAll(PageRequest.of(page,size, Sort.by("bandId").descending()));
        //bandId를 기준으로 내림차순으로 조회함.
    }

    /*
    private Band findVerifiedBandByQuery(long bandId){
        Optional<Band> optionalBand = bandsRepository.findByBand(bandId);
        Band findBand = optionalBand.orElseThrow(() ->
                new BusinessLoginException(ExceptionCode.BAND_NOT_FOUND));

    }
     해당값이 없을 경우, 예외처리하여 반을 찾을 수 없다는 예외코드를 뿜지만, 처음 기획의도는
     해당반이 없을 경우, 바로 가입신청을 할 수 있도록 유도하는것.
     음..가능할까?

     */



    //삭제관련
    public void deleteBands(long bandId){



    }







}
