package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.SampleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {

	private final SampleRepository sampleRepository;
	
	public void makeSample(String itemId) {
		sampleRepository.save(itemId);
	}
}
