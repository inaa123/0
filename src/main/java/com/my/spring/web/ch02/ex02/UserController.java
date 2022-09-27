package com.my.spring.web.ch02.ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex02")
@RequestMapping("ch02/ex02")
public class UserController {
	@GetMapping("userIn") //핸들러 선언
	public String userIn() {
		return "ch02/ex02/userIn"; //리턴해서 view name써줌
	}
}
