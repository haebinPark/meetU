package com.example.codestates.band.service;


import com.example.codestates.band.entity.Band;
import com.example.codestates.band.repository.BandRepository;
import com.example.codestates.exception.BusinessLogicException;
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


    //생성 관련
    public Band createBand(Band band) {

        String school = band.getSchool();
        int grade = band.getGrade();
        int bannum = band.getBannum();


        verifyExistBand(school, grade, bannum );
        band.setSchool(school);
        band.setGrade(grade);
        band.setBannum(bannum);
        //학교명, 학년, 반이 중복인지 조회하는 코드


        String schoolcode = band.getSchoolcode();

        if ("중학교".equals(schoolcode) || "고등학교".equals(schoolcode)) {
            if (grade>3){
                throw new IllegalArgumentException("중학교 또는 고등학교의 경우 4학년을 초과 입력 할 수 없습니다.");
            }//if
        }else {
            throw  new IllegalArgumentException("유효하지 않은 학교코드명입니다.");
        }
        // 중학교, 고등학교의 경우 4학년 이상 입력할 수 없게 하는 코드. 초등학교의 경우 이미 PostDto @Range로 입력범위를
        // 1~6까지로 제한하고 있기 때문에 조건문의 조건으로서 상정하지 않았다.

        return bandRepository.save(band);


   }


    private void verifyExistBand(String school, int grade, int bannum) {
        Optional<Band> band = bandRepository.findBySchoolAndGradeAndBannum(school,grade,bannum);
        if(band.isPresent())
            throw new BusinessLogicException(ExceptionCode.BAND_ALREADY_EXIST);
    }

    /* 반 가입신청시, 해당학교명, 학년, 반이 이미 등록되어 있는지 확인하는 코드입니다. 학교, 학년, 반이 하나라도
       겹치지 않을 경우 데이터베이스에 정상적으로 등록 될 것이며, 학교, 학년, 반이 모두 중복일 경우 에러코드 409와 함께 Band already exist
       라는 메세지를 송출합니다. */





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
    } //학교명으로 검색을 함. 학교명으로 검색하여 결과가 잡히지 않을 시, 예외코드 출력.

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
