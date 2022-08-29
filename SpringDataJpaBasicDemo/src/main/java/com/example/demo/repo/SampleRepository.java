package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Sample;

// JpaRepository�� ����ϸ� @Repository�� ������ �ʿ䰡 ����
public interface SampleRepository extends JpaRepository<Sample, Long>{
	// JPQL
}