package ncstest.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "nsc19_member")
@Entity
public class MemberEntity extends BaseEntity{
	
	@Id
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)//DB에저장시 문자열로 저장
	@Builder.Default
	@ElementCollection(fetch = FetchType.EAGER) //1:N
	private Set<MemberRole> roles=new HashSet<>(); 
	
	public void addRole(MemberRole role) {
		roles.add(role);
	}
}
