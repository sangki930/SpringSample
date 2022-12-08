package com.example.demo.service.sampleone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sampleone.SampleOne;
import com.example.demo.sampleone.repository.SampleOneRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sampleone.SampleOne;
import com.example.demo.sampleone.repository.SampleOneRepository;


@Service
public class SampleOneService {

	private final SampleOneRepository sampleOneRepository;
	
	@Autowired
	public SampleOneService(SampleOneRepository sampleOneRepository) {
		this.sampleOneRepository = sampleOneRepository;
	}
	
	// SampleOne 목록 부르기
	public List<SampleOne> getSampleOneList(){
		return sampleOneRepository.findAll();
	}
	
	// id값으로 SampleOne 가져오기
	public SampleOne getSampleOne(long id) {
		return sampleOneRepository.getById(id);
	}
	
	// SampleOne 1개 추가
	public SampleOne add(SampleOne sampleOne) {
		return sampleOneRepository.save(sampleOne);
	}
	
	// SampleOne 저장 및 플러쉬
	// flush는 영속성 컨텍스트의 변경 내용을 DB에 반영한다.
	public SampleOne addAndFlush(SampleOne sampleOne) {
		return sampleOneRepository.saveAndFlush(sampleOne);
	}
	
	// sampleOne으로 전부 지우기
	public void deleteSampleOne(SampleOne sampleOne) {
		sampleOneRepository.delete(sampleOne);
	}
	
	// SampleOne 전부 지우기
	public void deleteSampleOneAll() {
		sampleOneRepository.deleteAll();
	}
	
//	public Example<SampleOne> hasSampleOne(SampleOne sampleOne) {
//		return sampleOneRepository.exists(Example.of());
//	}
}
