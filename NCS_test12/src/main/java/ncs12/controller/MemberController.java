package ncs12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ncs12.domain.dto.LoginDto;
import ncs12.domain.dto.MemberDto;
import ncs12.service.MemberService;

@Controller
@RequestMapping("/mem/*")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("reg")
	public String regPage() {
		return "/member/registration";
	}
	
	@GetMapping("login")
	public String loginpPage() {
		return "/member/login"; //templates 경로
	}
	
	@PostMapping("reg")
	public String reg(MemberDto dto, Model model) {
		return service.save(dto, model);
	}
	
	@PostMapping("login")
	public String login(LoginDto dto, Model model) { // dto의 id, pw 매핑, 로그인 성공 시, 로그인 실패 시
		return service.login(dto, model);
	}
	
	@GetMapping("logout")
	public String logout() {
		return service.logout(); 
	}
}
