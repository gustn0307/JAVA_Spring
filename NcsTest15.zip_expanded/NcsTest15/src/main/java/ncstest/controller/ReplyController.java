package ncstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {

	@GetMapping("/boards/{bno}/replies")
	public String getReplies(@PathVariable int bno, Model model) {
		return "/reply/list";
	}
	
	@PostMapping("/boards/{bno}/replies")
	@ResponseBody
	public void writeReplies(@PathVariable int bno) {
		
	}
	
	@PutMapping("/boards/{bno}/replies/{rno}")
	@ResponseBody
	public void updateReplies(@PathVariable int bno, @PathVariable int rno) {
		
	}
	
	@DeleteMapping("/boards/{bno}/replies/{rno}")
	@ResponseBody
	public void deleteReplies(@PathVariable int bno, @PathVariable int rno) {
		
	}
}
