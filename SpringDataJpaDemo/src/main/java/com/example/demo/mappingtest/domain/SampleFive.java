package com.example.demo.mappingtest.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.common.CommonEntity;

public class SampleFive extends CommonEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String attr1;
	
	@Column
	private String attr2;
	
	@ManyToMany
	private Collection<SampleSix> sampleSix;

}
