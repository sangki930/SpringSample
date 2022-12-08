package com.example.demo.mappingtest.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class SampleSeven {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 28)
	private String name;
	
	@Column
	private String attr1;
	
	@OneToOne
	private SampleEight sampleEight;
}
