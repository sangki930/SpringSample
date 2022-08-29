package com.example.demo;

import org.springframework.stereotype.Component;

// SpringApplication Load시 초기 설정
@Component
public class DataInitComponent {
	// ApplicationRunner 활용
//	@Autowired
//    private MemberRepository memberRepository;
//
//    @Bean
//    public ApplicationRunner applicationRunner() {
//        return args -> {
//            for(int i = 0; i < 10; i++) {
//                Member member = new Member("id", "password", "name", "nickname");
//                memberRepository.save(member);
//            }
//        };
//    }  

}
