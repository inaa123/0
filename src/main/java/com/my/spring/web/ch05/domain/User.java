package com.my.spring.web.ch05.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd") //리퀘스트파라미터를 로컬데이터롭 ㅕㄴ환하기 위해
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul") //로컬데이트를 제이슨타입으로 변환하기 위해
	private LocalDate birthday;
	
}
