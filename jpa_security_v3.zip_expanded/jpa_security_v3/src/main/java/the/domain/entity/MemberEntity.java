package the.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class MemberEntity extends BaseEntity{
	
	@Id
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)//OneToMany로 table을 생성
	@Builder.Default
	private Set<NowonRole> roleSet=new HashSet<>();
	//연관된 MemberEntity 에만 연과괴어 관리됩니다.(부모 엔티티와 독립적으로 사용x)
	//항상 부모와 함께 저장,삭제되므로 cascade옵션은 x : cascade=ALL
	public void addRole(NowonRole role) {
		roleSet.add(role);
	}
	
}
