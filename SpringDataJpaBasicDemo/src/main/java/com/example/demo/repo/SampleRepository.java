package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Sample;

//Spring Data JPA 의존성 추가 후 JpaRepository를 상속하면 @Repository를 선언할 필요가 없음
public interface SampleRepository extends JpaRepository<Sample, Long>{
	// JPQL
}