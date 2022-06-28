package ncs12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ncs12.domain.dto.BoardDto;
import ncs12.mapper.BoardMapper;
import ncs12.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper; //mapper객체는 interface로 생성
	
	@Override
	public String getList(Model model) {
		
		List<BoardDto> result=mapper.findAll();
		model.addAttribute("list", result);
		
		return "board/list";
	}

	
	
}
