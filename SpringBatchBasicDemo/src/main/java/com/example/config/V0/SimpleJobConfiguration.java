package com.example.config.V0;

// 출처 : https://devbksheen.tistory.com/284
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class SimpleJobConfiguration {
//
//	private final JobBuilderFactory jobBuilderFactory;
//	private final StepBuilderFactory stepBuilderFactory;
//	
//	@Bean
//	public Job simpleJob() {
//		return jobBuilderFactory.get("simpleJob")
//				.start(simpleStep1())
//				.build();
//	}
//	
//	@Bean
//    public Step simpleStep1() {
//        return stepBuilderFactory.get("simpleStep1")
//            .tasklet((contribution, chunkContext) -> {
//                log.info(">>>>> This is simpleStep1");
//                return RepeatStatus.FINISHED;
//            })
//            .build();
//    }
//}
