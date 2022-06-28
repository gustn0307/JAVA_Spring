package chojc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {
	
	@GetMapping("/log/page")
	public String loginPage() {
		return "log/login";
	}
}
