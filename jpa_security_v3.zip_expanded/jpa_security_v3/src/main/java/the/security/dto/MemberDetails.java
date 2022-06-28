package the.security.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import the.domain.entity.MemberEntity;

@Getter
public class MemberDetails extends User{
	//principal 로 접근가능 필드
	private String name;
	
	//String username ==> email : id정보
	public MemberDetails(MemberEntity entity) {
		super(entity.getEmail(), entity.getPassword(), 
				entity.getRoleSet().stream()
				.map( role->new SimpleGrantedAuthority( role.getRole() ) )//role.getRole() == "ROLE_"+role.name()
				.collect(Collectors.toSet())
			);
		//roleSet : Set<NowonRole> -->
		//Collection<? extends GrantedAuthority> authorities
		this.name=entity.getName();
	}

}
