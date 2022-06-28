package the.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreenMemberController {
	
	
	@GetMapping("/member")
	public String member() {
		return "member/memberInfo";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/adminpage";
	}
}