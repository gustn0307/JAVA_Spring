package ncstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import ncstest.service.SignService;

@RequiredArgsConstructor
@Controller
public class SignController {
	
	
	private final SignService service;
	
	@GetMapping("/sign/signin")
	public String signinPage() {
		return "sign/signin";
	}
	
	@GetMapping("/sign/signup")
	public String signupPage() {
		return "sign/signup";
	}
	
}
