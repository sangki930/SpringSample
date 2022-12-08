package com.example.controller;

import java.util.Iterator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mock")
public class MockRestController {

	@GetMapping("/get")
	public ResponseEntity<?> getMethod(@RequestParam Long id){
		String ret = "응답 id : "+id;
		if(id==3) {
			return new ResponseEntity<>("응답 id : "+id, HttpStatus.BAD_REQUEST); 
		}
		log.info(ret);
		return new ResponseEntity<>("응답 id : "+id, HttpStatus.OK);
	}
	
	@GetMapping("/ret_str")
	public String getMethodTest(@RequestParam(required=true) Long id){
		
		return "응답 id : "+id;
	}
	
	@GetMapping("/test")
	public String getCookie(@CookieValue String value) {
		return "/test 실행";
	}
	
	@PostMapping("/test_post")
	public ResponseEntity<?> testPost(
			HttpHeaders headers,
			HttpServletRequest request,
			HttpSession session,
			Model model
			) {
		
		log.info(headers.toSingleValueMap().toString());
		
		log.info("session 살펴보기");
		Iterator<String> itr = session.getAttributeNames().asIterator();
		while(itr.hasNext())
			log.info(itr.next());
		
		model.addAttribute("model", "test");
//		log.info(request.)
		
		ResponseEntity<String> ret = new ResponseEntity<String>("반응",headers, HttpStatus.OK);
		return ret;
	}
}
