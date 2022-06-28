package ncs12.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ncs12.domain.dto.BoardDto;
import ncs12.domain.dto.MemberDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> findAll();

	void save(MemberDto dto);

}
