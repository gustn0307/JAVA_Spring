package the.security.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import the.domain.entity.GreenMember;
import the.domain.entity.GreenMemberRepository;
import the.security.dto.GreenAuthMemberDto;

@Log4j2
@RequiredArgsConstructor
@Service
public class GreenUserDetailService implements UserDetailsService{
	//UserDetailService 인터페이스를 제공: 사용자의 정보를 가져오는 핵심적인 역할을 담당
	
	private final GreenMemberRepository greenMemberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username : "+username);
		
		Optional<GreenMember> result=greenMemberRepository.findByEmail(username);
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("회원체크하세요");//예외발생
		}
		
		GreenMember e=result.get();
		Set<SimpleGrantedAuthority> roleSet=e.getRoleSet().stream()
				.map( role-> new SimpleGrantedAuthority("ROLE_"+role.name()) )
				.collect(Collectors.toSet());
		
		//SimpleGrantedAuthority 로 변환할때 'ROLE_' 접두어를 추가해서 사용
		//MemberRole -> SimpleGrantedAuthority 매핑
		
		//SimpleGrantedAuthority //Role정보를 얻기위한 구현체
		//회원이 존재하는지 체크..존재하면 회원정보를 UserDetails 리턴
		UserDetails userDetails=new GreenAuthMemberDto
				(e.getEmail(),e.getPassword(),e.getName(), roleSet);
		return userDetails;
	}

}