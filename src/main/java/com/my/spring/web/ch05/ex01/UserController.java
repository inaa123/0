package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

@RestController("ch05.ex01")
@RequestMapping("ch05/ex01")
public class UserController {
	@GetMapping("main")
	public ModelAndView main(ModelAndView mv) {//최초 리턴했을땐 모델과 뷰를 주어ㅑ함.
		mv.setViewName("ch05/ex01/main");
		return mv; //레스트 컨트롤러 상에 뷰를 리턴하는경우!
	} 
	//레스트풀에서의 첫번째핸들러
	@GetMapping("get")
	public User get(User user) { //rest이름?을 리퀘스트 타입과 일치시켜줄게요
		return user; //여기서 제이슨변환하는 코드가 없죠? 그래도 리퀘스트컨트롤러이기 때문에 ........
	}
	//쓰기는 포스트매핑
	@PostMapping("post")
	public User post(@RequestBody User user) { 
		return user;
	}
	//수정 1
	@PutMapping("put")
	public User put(@RequestBody User user) {
		return user;
	}
	//수정 2
	@PatchMapping("patch")
	public User patch(@RequestBody User user) {
		return user;
	}
	//삭제
	@DeleteMapping("delete")
	public User delete(@RequestBody User user) {
		return user;
	}
}
