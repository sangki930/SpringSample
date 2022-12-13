package com.example.config;




//@Configuration
//@Slf4j
////@EnableWebMvc
////@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurationSupport{
//	
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry
//                .addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry
//                .addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//	// BASE PACKAGE CONTROLLER
//	private final String BASE_PACKAGE = "com.example.controller";
//	
//	private final String TITLE = "Practice Swagger";
//	private final String DESCRIPTION = "practice swagger config";
//	private final String VERSION = "1.0";
//	
//	
//	@Bean
//    public Docket api() {
//		log.info("실행 확인");
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(TITLE)
//                .description(DESCRIPTION)
//                .version(VERSION)
//                .build();
//    }
//
//}
