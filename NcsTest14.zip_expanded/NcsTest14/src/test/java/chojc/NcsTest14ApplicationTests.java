package chojc;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import chojc.domain.entity.MemberEntity;
import chojc.domain.entity.MemberEntityRepository;
import chojc.secutity.MemberRole;

@SpringBootTest
class NcsTest14ApplicationTests {

	@Autowired
	MemberEntityRepository memberEntityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void 관리자회원테스트() {
		/* 관리자회원가입 로직 구현하고 테스트하세요 */ 
		MemberEntity entity=MemberEntity.builder()
				.email("강현수@test.com").password(passwordEncoder.encode("1111")).name("강현수")
				.build();
		entity.addRole(MemberRole.USER);
		entity.addRole(MemberRole.ADMIN);
		
		memberEntityRepository.save(entity);
		
	}
	
	
	//@Test
	void 회원가입테스트() {
		
		IntStream.rangeClosed(1, 4).forEach(i->{
			MemberEntity entity=MemberEntity.builder()
					.email("test"+i+"@test.com").password(passwordEncoder.encode("1234")).name("test"+i)
					.build();
			
			entity.addRole(MemberRole.USER);
			
			if(i==5) entity.addRole(MemberRole.ADMIN);
			
			memberEntityRepository.save(entity);
		});
		
		
		
	}

}
