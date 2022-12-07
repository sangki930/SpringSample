package com.example.demo.mappingtest.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class SampleSeven {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 28)
	private String name;
	
	
}
