package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SampleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleController {

	private final SampleService sampleService;
	
	@GetMapping("/v0/request")
	public ResponseEntity<?> request(String itemId) {
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
}
