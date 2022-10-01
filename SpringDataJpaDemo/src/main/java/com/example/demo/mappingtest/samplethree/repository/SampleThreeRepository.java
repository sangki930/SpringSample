package com.example.demo.mappingtest.samplethree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mappingtest.domain.SampleThree;

public interface SampleThreeRepository extends JpaRepository<SampleThree, Long>{
	
}
