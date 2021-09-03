package com.eat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.eat.vo.MemberVO;
import java.util.List;

@Mapper
public interface MemberDAO {
	
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(MemberVO member);
	
	List<MemberVO> selectAll();
	
	List<MemberVO> selectOne(@Param("id")Long id);
	List<MemberVO> selectGrade(@Param("grade")String grade);
	List<MemberVO> selectMemberId(@Param("id")Long id);

}
