package com.example.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SampleRepository {

	// 저장
	public void save(String itemId) {
		
		if(itemId.equals("ex")) {
			throw new IllegalArgumentException("예외 발생!!");
		}
		sleep(1000);
		
	}

	private void sleep(int millis) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(millis);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
