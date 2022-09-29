package com.example.demo.mappingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mappingtest.domain.SampleThree;

public interface SampleThreeRepository extends JpaRepository<SampleThree, Long>{
	
}
