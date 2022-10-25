package com.edu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LgTV{
	
	@Autowired // Spring Container가 초기화 시킴
	private AppleSpeaker speaker;
	
	public void turnOn() {
		System.out.println("LgTV---전원 켠다");
	}

	public void turnOff() {
		System.out.println("LgTV---전원 끈다");
	}

	public void soundUp() {
		speaker.volumeUp();
//		System.out.println("LgTV---소리 올린다");
	}

	public void soundDown() {
		speaker.volumeDown();
//		System.out.println("LgTV---소리 내린다");
	}
}
