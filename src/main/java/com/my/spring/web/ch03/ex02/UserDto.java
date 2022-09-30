package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {
	private String userName;
	private int age;
	private MultipartFile face; //얼굴사진올릴거다. 첨부파일 저장할 곳 필요한것
}
