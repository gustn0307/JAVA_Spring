package ncs12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import ncs12.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board")
	public String list(Model model) {
		//return "board/list"; //templates경로
		return service.getList(model);
	}
}
