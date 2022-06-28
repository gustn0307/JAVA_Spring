package ncstest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "ncs_board")
@Entity//DB 와 매핑되는 클래스
public class BoardEntity extends BaseEntity{// Repository 접근가능

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	@Column(nullable = false)
	private String subject;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private String writer;
	private int readCount;
	
	public BoardEntity update(String subject, String content) {
		this.subject = subject;
		this.content = content;
		return this;
	}
}