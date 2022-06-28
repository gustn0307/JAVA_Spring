package ncs12.mapper;

import org.apache.ibatis.annotations.Mapper;

import ncs12.domain.dto.MemberDto;

@Mapper
public interface TestMapper {

	int save(MemberDto dto);

	MemberDto logCheck(String id);

}
