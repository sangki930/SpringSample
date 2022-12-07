package com.example.demo.embeddedtest.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SampleNine {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String attr1;
	
	private String attr2;
	
	@Embedded
	private SampleTen sampleTen;
}
