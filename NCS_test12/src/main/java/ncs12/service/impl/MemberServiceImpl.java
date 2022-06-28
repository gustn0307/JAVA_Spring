package ncs12.service.impl;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ncs12.domain.dto.LoginDto;
import ncs12.domain.dto.MemberDto;
import ncs12.mapper.TestMapper;
import ncs12.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private TestMapper mapper; // mapper객체는 interface로 생성

	@Autowired
	private HttpSession session;

	@Override
	public String save(MemberDto dto, Model model) {
		int result = mapper.save(dto);
		if (result == 1) {
			model.addAttribute("success", dto.getName() + "님! 회원가입을 축하합니다.");
		} else {
			model.addAttribute("error", "오류발생");
		}
		return "member/login";
	}

	@Override
	public String login(LoginDto dto, Model model) { // 성공 시 index로, 실패 시 login 페이지로 이동
		MemberDto result = mapper.logCheck(dto.getId()); // 해당 id의 회원이 존재하는지 체크

		// id가 존재하면 MemberDto 객체가 반환
		if (result != null) { // id 존재하는지
			if (result.getPw().equals(dto.getPw())) { // pw 확인
				session.setAttribute("logInfo", result);
				return "redirect:/"; //로그인 성공시 index 페이지로 이동
			}
			System.out.println("비밀번호가 다른 경우!");
		}
		
		// 비정상적인 로그인 시도
		model.addAttribute("error", "회원이 아니거나 이미 탈퇴한 회원입니다.");
		return "/member/login";
	}

	@Override
	public String logout() {
		session.removeAttribute("logInfo");
		return "redirect:/";
	}
}
