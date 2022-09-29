package com.my.spring.web.ch02.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login")
	public String loginIn(@CookieValue(required=false) String userId,
			@ModelAttribute("user") UserDto user) {
		if(userId != null) user.setUserId(userId);
		return "ch02/ex06/login"; //login.jsp로 해석할것 
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,)
}
