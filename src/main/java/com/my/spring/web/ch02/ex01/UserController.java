package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ch02/ex01") //공통 url
public class UserController {
	@GetMapping("11") //자신만의 url , 핸들러에 붙는url -> 핸들러 매핑에 등록이 된다.
	public ModelAndView handler11(ModelAndView mv) {
		mv.addObject("user", new User("최한석", 11));
		mv.setViewName("ch02/ex01/user");
		
		return mv;
	}
	//또다른 컨트롤러 만들기!
	@GetMapping("21")
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21)); //얘는 모델로받는다.
		return "ch02/ex01/user";  //얘는 view로 받는다.
	}
	
	@GetMapping("22")
	public String handler22() { //String은 뷰 네임의 타입/ 모델을 리턴하지 않겠다  () 비어있음
		return "ch02/ex01/user"; //모델 없고 뷰만 잇어 -> /만보임  user 어트리뷰트가 없기 때문에 
	}
	
	@GetMapping("31")
	public void handler31(User user) {//리턴값이 없다. 핸들러31옆에 도메인을 넣어주나. 기본생성자를 콜해서 만든다.
		user.setUserName("양승일");
		user.setAge(31);
	}
	
	@GetMapping("32")
	public void handler32(@ModelAttribute("man") User user) {
		user.setUserName("서준한");
		user.setAge(32);
	}
	
	@GetMapping("41")
	public User handler41(User user) {
		user.setUserName("김가람");
		user.setAge(41);
		
		return user; 
	}
	
	@GetMapping("42")
	@ModelAttribute("man")
	public User handler42(User user) {
		user.setUserName("박건후");
		user.setAge(42);
		
		return user;
	}
}
//handler 리턴한 객체는 mvc architector에서 누가 리턴받나? 디스패처가 받는다. 
//handler11은 누가 콜함?->디스패처가 콜함