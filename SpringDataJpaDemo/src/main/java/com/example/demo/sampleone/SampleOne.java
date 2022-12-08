package com.example.demo.sampleone;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SampleOne extends CommonEntity{
	
	@Id
	@Column
	private Long id;
	
	@Column(unique = true)
	private String account;
	
	@Column(name = "name", insertable = true, nullable = false)
	private String name;
	
	@Email
	@Column
	private String email;
	
	@Column(length = 24)
	private String attr1;
	
	@Column
	private String attr2;
	
	@Column
	private Long longval;
	
	@PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        super.setCreated_at(now);
        super.setUpdated_at(now);
        super.setDeleted(false);;
    }

    @PreUpdate
    public void preUpdate() {
    	super.setUpdated_at(LocalDateTime.now());
    }
}
