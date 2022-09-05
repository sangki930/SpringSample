package com.example.demo.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 공통 엔티티 클래스

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonEntity {
	
	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime updated_at;
	private boolean deleted;
}
