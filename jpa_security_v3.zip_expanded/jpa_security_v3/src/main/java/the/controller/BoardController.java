package the.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
		
		@GetMapping("/boards")
		public String listPage() {
			return "board/list";
		}
		
		@GetMapping("/board/write")
		public String wrutePage() {
			return "board/write";
		}
}
