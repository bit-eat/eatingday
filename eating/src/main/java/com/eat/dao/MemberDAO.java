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
	MemberVO selectMember(@Param("userName")String userName,@Param("phoneNumber")String phoneNumber);
	List<MemberVO> selectAll();
	
	MemberVO selectOne(@Param("id")Long id);
	List<MemberVO> selectGrade(@Param("grade")String grade);
	MemberVO selectMemberId(@Param("userId")String userId);
	

}
