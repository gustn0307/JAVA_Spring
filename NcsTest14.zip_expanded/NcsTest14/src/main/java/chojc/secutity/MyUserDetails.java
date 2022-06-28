package chojc.secutity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import chojc.domain.entity.MemberEntity;
import lombok.Getter;

@Getter
public class MyUserDetails extends User{

	private String name;

	public MyUserDetails(MemberEntity entity) {
		super(
				entity.getEmail(),     	     //username 
				entity.getPassword(),        //password
				entity.getRoleSet().stream() //Role
									.map(role-> new SimpleGrantedAuthority(role.getRole()))
									.collect(Collectors.toSet()));
		
		//role은 Set콜랙션의 구성으로 GrantedAuthority타입을 요구: 
		//Set<MemberRole> -> Set<SimpleGrantedAuthority>
		//GrantedAuthority <- SimpleGrantedAuthority
		name=entity.getName();
		
	}

}
