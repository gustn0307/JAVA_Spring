package the.domain.entity;

import java.util.HashSet;
import java.util.Set;

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

@ToString(exclude = "roleSet")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GreenMember extends DateEntity{
	
	@Id
	private String email;
	private String password;
	private String name;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)//별도의 테이블로 만들어준다.
	@Builder.Default
	private Set<MemberRole> roleSet=new HashSet<>();
	
	public void addMemberRole(MemberRole memberRole) {
		roleSet.add(memberRole);
	}

}