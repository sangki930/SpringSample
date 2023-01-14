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
public class MultipleBatchConfig {

	private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    
    /* 다중 Step 단일 Job */
    @Bean
    public Job multipleJob(){

        Job multipleJob = jobBuilderFactory.get("multipleJob")
                .start(startStep())
                .next(nextStep())
                .next(lastStep())
                .build();

        return multipleJob;
    }

    @Bean
    public Step startStep() {
        return stepBuilderFactory.get("startStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Start Step!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step nextStep(){
        return stepBuilderFactory.get("nextStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Next Step!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step lastStep(){
        return stepBuilderFactory.get("lastStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Last Step!!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
    
}
