package the;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import the.domain.entity.GreenMember;
import the.domain.entity.GreenMemberRepository;
import the.domain.entity.MemberRole;

@SpringBootTest
class JpaSecurityV2ApplicationTests {
	
	@Autowired
	GreenMemberRepository greenMemberRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	//@Test
	void 회원1명조회() {
		String email="test1@test.com";
		GreenMember entity =greenMemberRepository.findByEmail(email).get();
		System.out.println(entity);
	}
	
	//@Test
	void 회원조회() {
		greenMemberRepository.findAll().forEach(e->{
			System.out.println(e);
		});
	}
	
	@Test
	void 회원20명() {
		
		IntStream.rangeClosed(1, 20).forEach(i->{
			
			GreenMember entity=GreenMember.builder()
					.email("test"+i+"@test.com")
					.name("유저"+i)
					.password(passwordEncoder.encode("1234"))//인코딩해서 저장
					.build();
			
			//default USER
			entity.addMemberRole(MemberRole.USER);
			
			if(i==1) {
				entity.addMemberRole(MemberRole.ADMIN);
			}
			
			greenMemberRepository.save(entity);
		});
		
	}

}