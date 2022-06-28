package ncs12.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int no;
	private String subject;
	private String content;
	private String writer;
	private int readCount;
	private LocalDateTime createdDate;
}
