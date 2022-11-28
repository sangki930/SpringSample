# Spring Bean 활용 Sample

## Spring Bean 이란?
- Spring IoC 컨테이너가 관리하는 자바 객체(POJO : Plain Old Java Object)

## @Bean
개발자가 직접 제어가 어려운 외부라이브러리 등을 Bean으로 등록

    @Bean
    public  void  execute(){
	    for(int i=0;i<5;i++){
		System.out.println("이것은 execute bean입니다.");
		}
    }
    

## @Component
개발자가 작성한 클래스나 인터페이스를 Bean으로 등록

    import org.springframework.stereotype.Component;
	import lombok.extern.slf4j.Slf4j;
	
    @Component
    @Slf4j
    public class SampleComponent{
	    String str;
	    int attr;
	    public SampleComponent(){
		    log.info("SampleComponent Bean 생성");
	    }
    }

    

## @Configuration
이 어노테이션을 선언한 클래스는 빈(Bean) 설정을 담당하는 클래스가 된다. 이 클래스 안에서 @Bean이 동봉된 메소드를 선언하면, 그 메소드를 통해 스프링 빈을 정의하고 생명주기를 설정하게 된다.

