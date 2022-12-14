package com.example.mvc.v3;

import java.util.Map;

public interface FrontControllerV3 {

	public MyModelAndView service(Map<String,String> paramMap); // value가 String인 이유는 텍스트로 넘어오기 때문

}
