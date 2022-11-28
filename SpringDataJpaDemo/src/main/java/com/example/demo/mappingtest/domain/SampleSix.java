package com.example.demo.mappingtest.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.common.CommonEntity;

public class SampleSix extends CommonEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "sample_six")
	private Collection<SampleFive> samplefives;
}
