package com.example.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
		name = "member",
		indexes = @Index(name = "idx__account__name", columnList = "account, name"),
		uniqueConstraints = {
				@UniqueConstraint(name="unique_account",columnNames = {"account","name"})
		}
	)
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor // lombok에서는 super()를 호출하지 않는다.
@NoArgsConstructor
@Builder
public class Member extends CommonEntity{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 12, unique = true, nullable = false)
	private String account;
	
	@Column(length = 20 ,nullable = false)
	private String name;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 100)
	@Email
	private String email;
	
	@Column
	@Enumerated
	private Role role;

	public Member(LocalDateTime created_at, LocalDateTime updated_at, boolean deleted, Long id, String account,
			String name, String password, Role role) {
		super(created_at, updated_at, deleted);
		this.id = id;
		this.account = account;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	
}
