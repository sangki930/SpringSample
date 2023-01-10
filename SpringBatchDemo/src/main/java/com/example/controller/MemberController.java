package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	// 추후 추가 예정 2023.01.10
	
}
