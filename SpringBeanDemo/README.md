**

## Spring Bean 활용 Sample

**
## @Bean
개발자가 직접 제어가 어려운 외부라이브러리 등을 Bean으로 등록

    @Bean
    public  void  execute(){
	    for(int i=0;i<5;i++){
		System.out.println("이것은 execute bean입니다.");
		}
    }
    

## @Component
개발자가 작성한 클래스를 Bean으로 등록

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

    
