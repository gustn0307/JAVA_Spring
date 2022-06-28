package the.domain.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
	USER("회원"),   //0
	ADMIN("관리자"); //0
	
	String title;
	
	MemberRole(String title) {
		this.title=title;
	}

}