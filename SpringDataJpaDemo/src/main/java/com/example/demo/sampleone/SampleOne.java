package com.example.demo.sampleone;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SampleOne extends CommonEntity{
	
	@Id
	@Column
	private Long id;
	
	@Column(name = "name", insertable = true, nullable = false)
	private String name;
	
	@Column(length = 24)
	private String attr1;
	
	@Column
	private String attr2;
	
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
