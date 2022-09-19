package com.example.demo.sampletwo;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name"})
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SampleTwo extends CommonEntity{
	
	@Id
	private Long id;
	
	private String name;
	
	private String attr1;
	
	private String attr2;
	
	@Enumerated(EnumType.STRING) // 컬럼이 Enum 타입일 때
	private Type type;
}

enum Type{
	ADMIN, USER
}