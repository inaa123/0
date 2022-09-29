package com.my.spring.web.ch02.ex06;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
			HttpSession session, HttpServletResponse response) {
		if(session.getAttribute("userId") == null)
			session.setAttribute("userId", user.getUserId());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("userId", user.getUserId());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/logout"; //이제 view를 리턴
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
