package ncs12.domain.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MemberDto {
	private int no;
	private String id;
	private String pw;
	private String name;
	private LocalDateTime createdDate;
}
