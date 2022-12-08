package com.example.demo.embeddedtest.domain;

import javax.persistence.Embeddable;

import lombok.ToString;

@Embeddable
@ToString
public class SampleTen {

	private Object attr1;
	
	private Object attr2;
}
