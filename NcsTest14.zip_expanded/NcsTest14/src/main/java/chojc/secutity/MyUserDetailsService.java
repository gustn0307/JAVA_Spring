package chojc.secutity;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import chojc.domain.entity.MemberEntity;
import chojc.domain.entity.MemberEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService{

	
	final MemberEntityRepository memberEntityRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println(username);
		
		Optional<MemberEntity> result=memberEntityRepository.findById(username);
		//회원이 존재유무 판단.
		if(result.isEmpty()) {//회원이 존재하지 않는경우
			throw new UsernameNotFoundException("회원이 존재하지 않는경우");
		}
		
		//아이디가 존재하는경우
		MemberEntity entity=result.get();
		//UserDetails : id(username), pw(password), role
		
		//인증정보는 : UserDetails 타입으로 리턴해야한다.
		return new MyUserDetails(entity);
	}

}
