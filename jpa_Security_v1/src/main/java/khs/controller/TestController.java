package khs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/test")
@Log4j2
@Controller
public class TestController {
	// 사용자 별로 구분하여 사이트 접속 가능, 모든 사용자 / user / 관리자
	
	@GetMapping("/all")
	public void all() {
		log.info("all 요청처리!");
	}
	
	@GetMapping("/member")
	public void member() {
		log.info("member 요청처리!");
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("admin 요청처리!");
	}
}
