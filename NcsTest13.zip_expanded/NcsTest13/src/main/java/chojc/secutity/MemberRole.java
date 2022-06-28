package chojc.secutity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
	
	USER("ROLE_USER","회원"),   //0
	ADMIN("ROLE_ADMIN","관리자");//1
	
	final String role;//final 수정할수 없다는 뜻 초기화를 해야한다.
	final String title;
	
	/*
	//@RequiredArgsConstructor하고 동일
	private MemberRole(String role, String title) {
		this.role = role;
		this.title = title;
	}
	
	*/
	
}
