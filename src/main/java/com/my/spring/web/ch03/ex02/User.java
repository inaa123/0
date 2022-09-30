package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User {
	private String userName;
	private int age;
	private String faceFilename; //첨부파일을 텍스트접근할땐 텍스트명만
}
