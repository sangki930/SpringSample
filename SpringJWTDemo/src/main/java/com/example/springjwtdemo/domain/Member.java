package com.example.springjwtdemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id; // ID값

    private String membername; // 유저 아이디

    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email; // 이메일 주소

    private String password; // 비밀번호
}
