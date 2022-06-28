package the.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;

@Controller
public class LogController {

	@GetMapping("/page/login")
	public String loginPage() {
		return "log/login";
	}
	
	
}
