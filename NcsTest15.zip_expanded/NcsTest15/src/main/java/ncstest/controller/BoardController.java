package ncstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BoardController {
	
	@GetMapping("/boards")
	public String getList(Model model) {
		return "board/list";
	}
	
	@GetMapping("/boards/write")
	public String writePage() {
		return "board/write";
	}
	
	@PostMapping("/boards/write")
	public String write() {
		return "redirect:/boards";
	}
	
	@GetMapping("/boards/{bno}")
	public String detail(@PathVariable int bno, Model model) {
		return "board/detail";
	}
	
	@PutMapping("/boards/{bno}")
	public String update(@PathVariable int bno) {
		return "redirect:/boards/"+bno;
	}
	
	@DeleteMapping("/boards/{bno}")
	public String delete(@PathVariable int bno) {
		return "redirect:/boards";
	}
	

}
