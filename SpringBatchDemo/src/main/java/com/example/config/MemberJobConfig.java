package com.example.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domain.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class MemberJobConfig {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("memberJob")
				.start(step())
				.build();
	}
	
	@Bean
	@JobScope
	public Step step() {
		return stepBuilderFactory.get("step")
				.<List<Member>,List<Member>>chunk(1)
				.reader(null)
				.writer(null)
				.build();
	}
	
	
	
}
