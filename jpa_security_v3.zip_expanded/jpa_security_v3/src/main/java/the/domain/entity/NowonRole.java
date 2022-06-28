package the.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NowonRole {
	
	USER("ROLE_USER", "회원"),    //0
	ADMIN("ROLE_ADMIN", "관리자");//1

	final String role;
	final String title;
	
}
