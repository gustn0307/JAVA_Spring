package ncstest;

import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;


import lombok.extern.log4j.Log4j2;
import ncstest.domain.entity.BoardEntity;
import ncstest.domain.entity.BoardEntityRepository;
import ncstest.domain.entity.MemberEntity;
import ncstest.domain.entity.MemberEntityRepository;
import ncstest.security.MemberRole;

@Log4j2
@SpringBootTest
class NcsTest17ApplicationTests {

	@Autowired
	MemberEntityRepository memberEntityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	BoardEntityRepository boardEntityRepository;
	
	@Test
	void 더미데이터입력테스트() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			MemberEntity memberEntity=MemberEntity.builder()
					.email("test"+i+"@test.com")
					.password(passwordEncoder.encode("1111"))
					.name("test"+i)
					.build();
			memberEntity.addRole(MemberRole.USER);
			memberEntityRepository.save(memberEntity);
			
			BoardEntity entity=BoardEntity.builder()
					.subject("제목 테스트 "+i)
					.content("내용 테스트 "+i)
					.writer(memberEntity.getName())
					.build();
			boardEntityRepository.save(entity);
		});
	}
	
	//@Test
	void baord입력테스트() {
		BoardEntity entity = BoardEntity.builder()
				.subject("제목테스트 ")
				.content("내용테스트 ")
				.writer("작성자 테스트")
				.build();
		BoardEntity result = boardEntityRepository.save(entity);
		if(result!=null) {
			log.info("board 입력 테스트 결과: "+result);
		}
		
		
	}
	//@Test	
	void board모두읽어오기테스트() {
		List<BoardEntity> result = boardEntityRepository.findAll();
		for(BoardEntity entity : result) {
			log.info("board : "+entity);
		}
	}
	//@Test
	@Transactional
	@Commit
	void board수정테스트() {
		BoardEntity result = boardEntityRepository.findById(10L)
							.map(e->e.update("제목 수정","내용 수정")).orElseThrow();
		if(result!=null) {
			log.info("board 수정 : "+result);
		}
	}
	//@Test
	void baord삭제() {
		boardEntityRepository.deleteById(11L);
		log.info("board 삭제");
	}
	
	

}
