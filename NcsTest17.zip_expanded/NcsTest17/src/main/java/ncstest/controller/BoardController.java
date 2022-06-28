package ncstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BoardController {
	
	//게시글 목록
	@GetMapping("/boards")
	public String list(Model model) {
		log.debug("list() 실행!");
		return "board/list";
	}
	//게시글 작성화면
	@GetMapping("/boards/write")
	public String writePage() {
		log.debug("writePage() 실행!");
		return "board/write";
	}
	//게시글 작성처리
	@PostMapping("/boards/write")
	public String write() {
		log.debug("write() 실행!");
		return "redirect:/boards";
	}
	//게시글 상세화면
	@GetMapping("/boards/{bno}")
	public String detail(@PathVariable long bno, Model model) {
		log.debug("detail() 실행!");
		return "board/detail";
	}
	//게시글 수정
	@PutMapping("/boards/{bno}")
	public String update(@PathVariable long bno) {
		log.debug("update() 실행!");
		return "redirect:/board/"+bno;
	}
	//게시글 삭제
	@DeleteMapping("/boards/{bno}")
	public String delete(@PathVariable long bno) {
		log.debug("delete() 실행!");
		return "redirect:/boards";
	}

}
