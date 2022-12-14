package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Employee {
	@Id
	@GeneratedValue
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
