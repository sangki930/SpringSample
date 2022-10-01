package com.example.demo.mappingtest.samplefour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mappingtest.domain.SampleThree;

public interface SampleFourRepository extends JpaRepository<SampleThree, Long>{
	
}
