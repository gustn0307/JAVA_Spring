package ncstest.domain.entity;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyEntityRepository extends JpaRepository<ReplyEntity, Long>{

	List<ReplyEntity> findAllByBoardBno(long bno, Pageable pageable);
	//Board_bno : TestReplyEntity의 board 내부의(_) bno 컬럼
	//BoardBno : TestReplyEntity의 board 내부의(_) bno 컬럼

	//List<TestReplyEntity> findAllByBno(long bno);
	//Entity객체기준 컬럼에는 bno는 존재하지않아 에러..

}
