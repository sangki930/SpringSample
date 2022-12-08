package com.example.demo.embeddedtest.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
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
