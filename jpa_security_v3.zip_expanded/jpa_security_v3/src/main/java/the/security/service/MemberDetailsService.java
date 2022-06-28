package the.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import the.domain.entity.MemberEntity;
import the.domain.entity.MemberEntityRepository;
import the.security.dto.MemberDetails;

@Service
public class MemberDetailsService implements UserDetailsService{
	
	@Autowired
	MemberEntityRepository memberEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : "+username);
		Optional<MemberEntity> 	result=memberEntityRepository.findById(username);
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("존재하지 않는 이메일 또는 아이디 입니다.");
		}
		
		MemberEntity entity=result.get();
		System.out.println(entity);
		
		return new MemberDetails(entity);
	}

}
