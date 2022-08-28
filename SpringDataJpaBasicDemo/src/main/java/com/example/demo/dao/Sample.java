package com.example.demo.dao;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Sample {

	@Id
	private Long id;
	private String name;
	private String attr1;
	private String attr2;
	private Instant created;
	private LocalDateTime updated;
	
}
