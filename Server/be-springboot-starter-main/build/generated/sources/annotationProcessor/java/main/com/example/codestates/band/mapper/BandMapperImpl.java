package com.example.codestates.band.mapper;

import com.example.codestates.band.dto.BandPatchDto;
import com.example.codestates.band.dto.BandPostDto;
import com.example.codestates.band.dto.BandResponseDto;
import com.example.codestates.band.entity.Band;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-13T18:34:33+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class BandMapperImpl implements BandMapper {

    @Override
    public Band bandPostDtoToBand(BandPostDto bandPostDto) {
        if ( bandPostDto == null ) {
            return null;
        }

        Band band = new Band();

        band.setSchool( bandPostDto.getSchool() );
        band.setSchoolcode( bandPostDto.getSchoolcode() );
        band.setGrade( bandPostDto.getGrade() );
        band.setBannum( bandPostDto.getBannum() );
        band.setJoinpass( bandPostDto.getJoinpass() );
        band.setUsername( bandPostDto.getUsername() );

        return band;
    }

    @Override
    public Band bandPatchDtoToBand(BandPatchDto bandPatchDto) {
        if ( bandPatchDto == null ) {
            return null;
        }

        Band band = new Band();

        band.setBandId( bandPatchDto.getBandId() );
        band.setSchool( bandPatchDto.getSchool() );
        band.setSchoolcode( bandPatchDto.getSchoolcode() );
        band.setGrade( bandPatchDto.getGrade() );
        band.setBannum( bandPatchDto.getBannum() );
        band.setJoinpass( bandPatchDto.getJoinpass() );

        return band;
    }

    @Override
    public BandResponseDto bandToBandResponseDto(Band band) {
        if ( band == null ) {
            return null;
        }

        BandResponseDto.BandResponseDtoBuilder bandResponseDto = BandResponseDto.builder();

        if ( band.getBandId() != null ) {
            bandResponseDto.bandId( band.getBandId() );
        }
        bandResponseDto.school( band.getSchool() );
        bandResponseDto.schoolcode( band.getSchoolcode() );
        bandResponseDto.grade( band.getGrade() );
        bandResponseDto.bannum( band.getBannum() );
        bandResponseDto.joinpass( band.getJoinpass() );
        bandResponseDto.username( band.getUsername() );
        if ( band.getStatus() != null ) {
            bandResponseDto.status( band.getStatus().name() );
        }

        return bandResponseDto.build();
    }

    @Override
    public List<BandResponseDto> bandToBandResponseDtos(List<Band> bands) {
        if ( bands == null ) {
            return null;
        }

        List<BandResponseDto> list = new ArrayList<BandResponseDto>( bands.size() );
        for ( Band band : bands ) {
            list.add( bandToBandResponseDto( band ) );
        }

        return list;
    }
}
