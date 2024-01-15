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
        String schoolcode = band.getSchoolcode();
        int grade = band.getGrade();
        int bannum = band.getBannum();



        verifyExistBand(school, schoolcode, grade, bannum );
        band.setSchool(school);
        band.setGrade(grade);
        band.setBannum(bannum);
        band.setSchoolcode(schoolcode);
        //학교명, 학년, 반이 중복인지 조회하는 코드


        if("초등학교".equals(schoolcode)){
            if (grade > 6) {
                throw new IllegalArgumentException("초등학교의 경우 1학년부터 6학년까지만 선택이 가능합니다.");
            }//if
        } else if ("중학교".equals(schoolcode) || "고등학교".equals(schoolcode)) {
            if (grade>3){
                throw new IllegalArgumentException("중학교 또는 고등학교의 경우 4학년을 초과 입력 할 수 없습니다.");
            }//if
        }else {
            throw  new IllegalArgumentException("유효하지 않은 학교코드명입니다.");
        }
        // 중학교, 고등학교의 경우 4학년 이상 입력할 수 없게 하는 코드.

        return bandRepository.save(band);


   }


    private void verifyExistBand(String school, String schoolcode, int grade, int bannum) {
        Optional<Band> band = bandRepository.findBySchoolAndSchoolcodeAndGradeAndBannum(school,schoolcode, grade,bannum);
        if(band.isPresent())
            throw new BusinessLogicException(ExceptionCode.BAND_ALREADY_EXIST);
    }

    /* 반 가입신청시, 해당학교명, 학년, 반이 이미 등록되어 있는지 확인하는 코드입니다. 학교, 학년, 반이 하나라도
       겹치지 않을 경우 데이터베이스에 정상적으로 등록 될 것이며, 학교, 학년, 반이 모두 중복일 경우 에러코드 409와 함께 Band already exist
       라는 메세지를 송출합니다. */




    //수정관련
    public Band updateBand(Band band){

        Band findBand = findVerifiedBandId(band.getBandId());

        Optional.ofNullable(band.getSchool()).ifPresent(school ->
                findBand.setSchool(school));

        Optional.ofNullable(band.getSchoolcode()).ifPresent(schoolcode ->
                findBand.setSchoolcode(schoolcode));

        Optional.ofNullable(band.getGrade()).ifPresent(grade ->
                findBand.setGrade(grade));

        Optional.ofNullable(band.getBannum()).ifPresent(bannum ->
                findBand.setBannum(bannum));

        Optional.ofNullable(band.getJoinpass()).ifPresent(joinpass ->
                findBand.setJoinpass(joinpass));

        Optional.ofNullable(band.getStatusUpdate()).ifPresent(statusUpdate ->
                findBand.setStatusUpdate(statusUpdate));

        return bandRepository.save(findBand);


    }


    public Band findBand(Long bandId) {
        return findVerifiedBandId(bandId); }


    public Band findSchool(String school) {
        return findVerifiedBandByQuery(school);
    }


    public Page<Band> findSchools(int page, int size){
        return bandRepository.findAll(PageRequest.of(page,size, Sort.by("school").descending()));
        //school를 기준으로 내림차순으로 조회함.

    }



    //삭제관련
    public void deleteBands(long bandId){

        Band band = findVerifiedBandId(bandId);
        bandRepository.delete(band);

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


    public Band findVerifiedBandSchool(String school){

        Optional<Band> optionalBand = bandRepository.findBySchool(school);
        Band findSchool = optionalBand.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.CANT_FIND_SCHOOL));


        return findSchool;
    }//검색관련

    public Band findVerifiedBandId(Long bandId){

        Optional<Band> optionalBand = bandRepository.findByBandId(bandId);
        Band findBandId = optionalBand.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.BAND_NOT_EXIST));


        return findBandId;
    }




}
