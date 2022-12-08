package com.example.demo.embeddedtest.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@ToString
@Getter
@Setter
public class SampleTen {

	private Object attr1;
	
	private Object attr2;
}
