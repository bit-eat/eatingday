package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

@Mapper
public interface MemberDAO {
	
	void insertMember(MemberVO membervo);
	void updateMember(MemberVO membervo);
	void deleteMember(MemberVO membervo);
	void selectMember(MemberVO membervo);
	List<MemberVO> selectAll();
	
	List<MemberVO> selectOne(@Param("id")Long id);
	List<MemberVO> selectGrade(@Param("grade")String grade);
	List<MemberVO> selectMemberId(@Param("id")Long id);
	Object memberList();
		
	

}
