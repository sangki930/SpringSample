package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.components.Person;

@Service
public class ApplicationService {

	private final Person person;

	@Autowired
	public ApplicationService(@Qualifier(value = "teacher") Person person) {
		this.person = person;
		person.introduce();
	}
}
