package the.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreenMemberRepository extends JpaRepository<GreenMember, String>{

	Optional<GreenMember> findByEmail(String email);

}