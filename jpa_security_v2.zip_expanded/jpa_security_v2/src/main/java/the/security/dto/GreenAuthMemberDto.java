package the.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GreenAuthMemberDto extends User{
	
	private String email;
	private String name;
	
	/**
	 * 
	 * @param username : id정보 여기에서는 eamil
	 * @param password : 비밀번호
	 * @param name     : 이름
	 * @param authorities : 권한
	 */
	public GreenAuthMemberDto
	(String username, String password, String name, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		email=username;//ID정보
		this.name=name;
		
	}
}