package com.example.demo.mappingtest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class SampleFour extends CommonEntity{

	@Id
	private Long id;
	
	private String name;
	
	private String attr1;
	
	
}
