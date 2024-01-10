package com.example.codestates.band.entity;


import org.springframework.data.jpa.repository.JpaRepository;

//데이터베이스 생성을 위한 엔티티 작업(CREATE, READ, UPDATE, DELETE)을 수행 하기 위한 인터페이스임
public interface BandsRepository extends JpaRepository<Bands, Long> {

    //JpaRepository가 CREATE, READ, UPDADTE, DELETE작업을 제공함.
    //직업 SQL 파일을 삽입하여 사용할 수도 있음.
    //그러나 현 프로젝트는 배운것을 최대한 복습하는 것이므로, 직접 SQL입력은 지양하며, 최대한 spring DATA SPA를 사용하도록함.
    //특별한 경우에만 직접 SQL을 사용해야 한다면 해당 내용을 주석으로 추가.
}
