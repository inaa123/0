package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("ch03.ex02")
@RequestMapping("ch03/ex02/user")
public class UserController {
	@Value("${attachPath}") private String attachPath; //attachPath프라퍼티 벨류가 attachPath의 인덱션이 되는거다
	
	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping
	public String userOut(UserDto userDto, HttpServletRequest request, User user) {
		String fileName = userDto.getFace().getOriginalFilename();
		saveFile(attachPath + "/" + fileName, userDto.getFace()); //클라이언트가 입력한 파일을 서버에 이 위치attachPath + "/" + fileName,에다 저장하는 것
		
		user.setFaceFilename(fileName); //그리고 db에 저장할거잖아요?
		
		return "ch03/ex02/userOut"; //뷰만리턴하고 끝낸다. 모델은 따로 없음!
	}
						//파일명은 여기에,    클라이언트가 입력한 파일?은 여기에..
	private void saveFile(String fileName, MultipartFile file) {
		try {
			file.transferTo(new File(fileName));
		} catch(IOException e) {}
	}
} 
