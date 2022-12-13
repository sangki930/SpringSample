package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

	private Long id;
	private String empno;
	private String name;
	private String team;
	
	public Employee(String empno, String name, String team) {
		this.empno = empno;
		this.name = name;
		this.team = team;
	}
	
}