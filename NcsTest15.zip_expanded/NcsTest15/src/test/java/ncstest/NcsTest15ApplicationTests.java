package ncstest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import ncstest.domain.entity.MemberEntity;
import ncstest.domain.entity.MemberEntityRepository;
import ncstest.security.MemberRole;

@SpringBootTest
class NcsTest15ApplicationTests {

	@Autowired
	MemberEntityRepository memberEntityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void 관리자회원테스트() {
		/* 관리자회원가입 로직 구현하고 테스트하세요*/
		
		MemberEntity entity=MemberEntity.builder()
				.email("이름@test.com")
				.password(passwordEncoder.encode("1111"))
				.name("이름")
				.build();
		
		entity.addRole(MemberRole.USER);
		entity.addRole(MemberRole.ADMIN);
		memberEntityRepository.save(entity);
	}
	
	
	//@Test
	void 회원가입테스트() {
		
		IntStream.rangeClosed(1, 4).forEach(i->{
			MemberEntity entity=MemberEntity.builder()
					.email("test"+i+"@test.com")
					.password(passwordEncoder.encode("1234")).name("test"+i)
					.build();
			
			entity.addRole(MemberRole.USER);
			
			if(i==5) entity.addRole(MemberRole.ADMIN);
			
			memberEntityRepository.save(entity);
		});
		
		
		
	}

}
