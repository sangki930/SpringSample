package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MockController {

	@GetMapping("/swagger-ui/index.html")
	public String func() {
		return "/swagger-ui/index.html";
	}
}
