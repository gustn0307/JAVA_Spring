package the;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import the.domain.entity.BoardEntity;
import the.domain.entity.BoardEntityRepository;
import the.domain.entity.MemberEntity;
import the.domain.entity.MemberEntityRepository;
import the.domain.entity.NowonRole;

@SpringBootTest
class JpaSecurityV3ApplicationTests {

	@Autowired
	BoardEntityRepository boardEntityRepository;
	
	//@Test
	void 게시글임시입력() {
		
		BoardEntity entity=BoardEntity.builder()
				.subject("제목 테스트").content("내용 테스트").writer("테스트")
				.build();
		boardEntityRepository.save(entity);
		
	}
	
	
	@Autowired
	MemberEntityRepository memberEntityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Test
	void 회원입력() {
		IntStream.rangeClosed(1, 2).forEach(i->{
			MemberEntity entity=MemberEntity.builder()
					.email("test"+i+"@test.com").name("test"+i)
					.password(passwordEncoder.encode("1234"))
					.build();
			
			entity.addRole(NowonRole.USER);
			if(i==1) {
				entity.addRole(NowonRole.ADMIN);
			}
			
			memberEntityRepository.save(entity);
		});
	}

}
