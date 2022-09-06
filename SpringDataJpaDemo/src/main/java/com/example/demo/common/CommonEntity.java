package com.example.demo.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ���� ��ƼƼ Ŭ����

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass // 
public class CommonEntity {
	
	@Column(updatable = false)
	@CreatedDate // ��ƼƼ ���� �ð�
	private LocalDateTime created_at; // ��ƼƼ ���� �ð�
	
	@LastModifiedDate // ������ ���� �ð�
	private LocalDateTime updated_at; // �ֱ� ���� �ð�
	private boolean deleted;
}
