package com.example.demo.sampleone.service;

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
	
	public SampleOne addAndFlush(SampleOne sampleOne) {
		return sampleOneRepository.saveAndFlush(sampleOne);
	}
}
