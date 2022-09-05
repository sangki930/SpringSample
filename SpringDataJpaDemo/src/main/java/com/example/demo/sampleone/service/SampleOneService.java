package com.example.demo.sampleone.service;

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
	
	public List<SampleOne> getSampleOneList(){
		return sampleOneRepository.findAll();
	}
	
	public SampleOne getSampleOne(long id) {
		return sampleOneRepository.getById(id);
	}
	
	public SampleOne addAndFlush(SampleOne sampleOne) {
		return sampleOneRepository.saveAndFlush(sampleOne);
	}
	
	public void deleteSampleOne(SampleOne sampleOne) {
		sampleOneRepository.delete(sampleOne);;
	}
	
//	public Example<SampleOne> hasSampleOne(SampleOne sampleOne) {
//		return sampleOneRepository.exists(Example.of());
//	}
}
