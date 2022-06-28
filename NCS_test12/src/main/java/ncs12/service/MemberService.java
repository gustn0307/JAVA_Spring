package ncs12.service;

import org.springframework.ui.Model;

import ncs12.domain.dto.LoginDto;
import ncs12.domain.dto.MemberDto;

public interface MemberService {
	
	String save(MemberDto dto, Model model);

	String login(LoginDto dto, Model model);

	String logout();
}
