package com.eat.service;

import java.lang.reflect.Member;
import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.eat.vo.MemberVO;

public interface MemberService {
	
	
	 void insertMember(MemberVO member);
	 void updateMember(MemberVO member);
	 void deleteMember(MemberVO member);
	 boolean validateDuplicateMember(Member member);
	 
	 List<MemberVO> selectAll();
	 
	List<MemberVO> selectOne(@Param("id")Long id);
	List<MemberVO> selectGrade(@Param("grade")String grade);
	List<MemberVO> selectMemberId(@Param("id")Long id);
	List<MemberVO> findId(@Param("userName")String userName, @Param("phoneNumber")String phoneNumber);
	

	 
	
	
}
