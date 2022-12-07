package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Sample;
import com.example.demo.repo.SampleRepository;

@Service
public class SampleService {
	
	private final SampleRepository sampleRepository;

	// 생성자에 의한 의존성 주입
	@Autowired
	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}
	

	// 모든 sample 객체 얻기
	public List<Sample> getAllSamples(){
		return sampleRepository.findAll();
	}
	
	// id로 sample 하나 얻기
	public Sample getSample(long id) {
		Optional<Sample> opt = sampleRepository.findById(id);
		
		return opt.orElseThrow(()->{throw new NullPointerException("해당하는 Sample이 없습니다.");});
	}
	
	// id로 Sample 하나 얻기(null을 반환할 수 있음)
	public Sample getSampleOld(long id) {
		return sampleRepository.getById(id);
	}
	
	// Sample 하나 추가
	public Sample addSample(Sample sample) {
		// save 메소드는 null을 허용하지 않음
		if(sample == null) {
			throw new NullPointerException("Sample은 Null을 허용하지 않습니다.");
		}
		return sampleRepository.save(sample);
	}
	
	// Sample 수정
	public Sample updateSample(Sample sample) {
		
		Sample old = getSample(sample.getId());
		old.setName(sample.getName());
		old.setAttr1(sample.getAttr1());
		old.setAttr2(sample.getAttr2());
		
		return sampleRepository.save(sample);
	}
	
	// Sample 삭제
	public void deleteSample(Sample sample) {
		sampleRepository.delete(sample);
	}
	

}
