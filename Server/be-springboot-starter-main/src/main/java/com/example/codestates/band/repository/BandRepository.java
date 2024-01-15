package com.example.codestates.band.repository;


import com.example.codestates.band.entitiy.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BandRepository extends JpaRepository <Band ,Long> {

}
