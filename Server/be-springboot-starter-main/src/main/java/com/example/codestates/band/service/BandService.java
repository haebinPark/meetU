package com.example.codestates.band.service;


import com.example.codestates.band.entity.Band;
import com.example.codestates.band.repository.BandRepository;
import com.example.codestates.exception.BusinessLogicException;
import com.example.codestates.exception.Exception;
import com.example.codestates.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandService {

    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository){this.bandRepository = bandRepository;}

    public Band createBand(Band band) {

        String school = band.getSchool();

        verifyExistBand(school);
        band.setSchool(school);
        //이미 등록된 학교인지 확인하는 코드. 학교중복되어도 상관없는데..억지로 만든거임..


    return bandRepository.save(band);

   }

    private void verifyExistBand(String school) {
        Optional<Band> band = bandRepository.findBySchool(school);
        if(band.isPresent())
            throw new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND);
    }





    //조회관련

    public Band updateBand(Band band){

        Band findBand = findVerifiedBand(band.getSchool());

        Optional.ofNullable(band.getSchoolcode()).ifPresent(schoolcode ->
                findBand.setSchoolcode(schoolcode));

        Optional.ofNullable(band.getGradeAndBannum()).ifPresent(gradeAndBannum ->
                findBand.setGradeAndBannum(gradeAndBannum));

        Optional.ofNullable(band.getStatus()).ifPresent(status ->
                findBand.setStatus(status));

        return bandRepository.save(findBand);


    }


    public Band findVerifiedBand(String school){

        Optional<Band> optionalBand = bandRepository.findBySchool(school);
        Band findSchool = optionalBand.orElseThrow(() ->
                                    new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND));


        return findSchool;
    }



    public Band findBand(String school) { return findVerifiedBandByQuery(school); }


    public Page<Band> findBands(int page, int size){
        return bandRepository.findAll(PageRequest.of(page,size, Sort.by("bandId").descending()));
        //bandId를 기준으로 내림차순으로 조회함.

    }






    //삭제관련
    public void deleteBands(long bandId){



    }


    private Band findVerifiedBandByQuery(String school) {
        Optional<Band> optionalBand = bandRepository.findBySchool(school);
        Band findSchool =
                optionalBand.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.BAND_NOT_FOUND));

        return findSchool;
    }

        /*
    private Band findVerifiedBandByQuery(long bandId){
        Optional<Band> optionalBand = bandRepository.findByBand(bandId);
        Band findBand = optionalBand.orElseThrow(() ->
                new BusinessLoginException(ExceptionCode.BAND_NOT_FOUND));

    }
     해당값이 없을 경우, 예외처리하여 반을 찾을 수 없다는 예외코드를 뿜지만, 처음 기획의도는
     해당반이 없을 경우, 바로 가입신청을 할 수 있도록 유도하는것.
     음..가능할까?

     */



}
