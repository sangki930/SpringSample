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
@MappedSuperclass // 
public class CommonEntity {
	
	@Column(updatable = false)
	@CreatedDate // 엔티티 생성 시각
	private LocalDateTime created_at; // 엔티티 생성 시각
	
	@LastModifiedDate // 마지막 수정 시각
	private LocalDateTime updated_at; // 최근 수정 시각
	private boolean deleted;
}
