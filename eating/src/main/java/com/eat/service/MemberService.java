package com.eat.service;

import java.lang.reflect.Member;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

public interface MemberService {
	
	// void selectMemberId(MemberVO member);
	 void insertMember(MemberVO member);
	 void updateMember(MemberVO member);
	 void deleteMember(MemberVO member);
	 void selectMember(MemberVO membervo);
	 boolean validateDuplicateMember(Member member);
	 
	 List<MemberVO> selectAll();
	 
	List<MemberVO> selectOne(@Param("id")Long id);
	List<MemberVO> selectGrade(@Param("grade")String grade);
	List<MemberVO> selectMemberId(@Param("id")Long id);
	
	

	 
	
	
}
