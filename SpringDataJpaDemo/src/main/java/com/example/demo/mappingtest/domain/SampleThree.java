package com.example.demo.mappingtest.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class SampleThree extends CommonEntity{
	
	@Id
	private Long id;
	
	private String name;
	
	private String attr1;
	
	private String attr2;
	
	private String attr3;
	
	@OneToMany(mappedBy = "sampleThree")
	private List<SampleFour> list;
}
