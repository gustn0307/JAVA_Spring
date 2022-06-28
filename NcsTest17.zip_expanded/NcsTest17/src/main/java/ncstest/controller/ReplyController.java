package ncstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ReplyController {
	//댓글목록
	@GetMapping("/boards/{bno}/replies")
	public String list(@PathVariable long bno ,Model model) {
		log.debug("list() 실행");
		return "reply/list";
	}
	//댓글 작성처리
	@ResponseBody
	@PostMapping("/boards/{bno}/replies")
	public void save(@PathVariable long bno ) {
		log.debug("save() 실행");
	}
	//댓글 수정
	@ResponseBody
	@PutMapping("/boards/{bno}/replies/{rno}")
	public void update(@PathVariable long bno, @PathVariable long rno) {
		log.debug("update() 실행");
	}
	//댓글 삭제
	@ResponseBody
	@DeleteMapping("/boards/{bno}/replies/{rno}")
	public void delete(@PathVariable long bno, @PathVariable long rno) {
		log.debug("delete() 실행");
	}
}
