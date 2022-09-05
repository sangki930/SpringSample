package com.example.demo.sampleone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.sampleone.SampleOne;

public interface SampleOneRepository extends JpaRepository<SampleOne, Long>{
	
	public SampleOne findByAttr1(String attr1);
}