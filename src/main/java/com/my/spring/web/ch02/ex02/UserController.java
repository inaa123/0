package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("ch02.ex02") // ch02.ex01의 UserController와 bean id가 중복되기 때문에 에러 > 이름을 붙여준다
@RequestMapping("ch02/ex02")
public class UserController { // bean의 id, mapping url이 유일해야한다
   @GetMapping("userIn")
   public String userIn() {
      return "ch02/ex02/userIn";
   }
   /*
   @PostMapping("userOut") // 메소드 타입이 post이기 때문에
   public String userOut(@RequestParam String userName, // string으로 자동 변환, 읽어서 userName 값으로 write한다
                     @RequestParam int age, // int로 자동변환
                     @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate, // pattern: 형식을 써주어야 형식대로 리턴된다
                     Model model) { // 데이터 타입을 따로 써주지 않아도 된다, 자동으로 변환된다
      model.addAttribute("user", new User(userName, age, regDate));
      return "ch02/ex02/userOut"; //view
   }
   */
   @PostMapping("userOut")
   public String userOut(String userName,
                     int age,
                     @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
                     Model model) {
      model.addAttribute("user", new User(userName, age, regDate));
      return "ch02/ex02/userOut";
   } // @RequestParam이 없어도 잘 읽어들이지만, 3개 데이터가 흩어져 있다 > 모아서 관리하는 것이 좋다
} // http://localhost/ch02/ex02/userIn 입력해서 확인