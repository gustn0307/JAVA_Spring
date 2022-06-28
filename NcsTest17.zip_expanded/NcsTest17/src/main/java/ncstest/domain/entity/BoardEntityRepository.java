package ncstest.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long>{
	//사용자가 쿼리메서드를 만들어 쓸때 
}
