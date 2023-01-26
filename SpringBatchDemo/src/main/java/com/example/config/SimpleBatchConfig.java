package com.example.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class SimpleBatchConfig {

	private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
	
    // 단일 Step이 들어간 Job 생성 예시
    @Bean
    public Job simpleJob(){
        Job simpleJob = jobBuilderFactory.get("simpleJob")
                .start(simpleStep())
                .build();

        return simpleJob;
    }
    
    // 단일 step
    @Bean
    public Step simpleStep() {
        return stepBuilderFactory.get("step")
                .tasklet((contribution, chunkContext) -> {
                	log.info("step 생성중");
                    log.info("Step!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
    
}
