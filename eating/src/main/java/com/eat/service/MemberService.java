package com.eat.service;

import java.lang.reflect.Member;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

public interface MemberService {
	
	void insertMember(MemberVO membervo);
	void updateMember(MemberVO membervo);
	void deleteMember(MemberVO membervo);
	MemberVO selectMember(String userName,String phoneNumber);
	List<MemberVO> selectAll();
	
	MemberVO selectOne(Long id);
	List<MemberVO> selectGrade(String grade);
	List<MemberVO> selectMemberId(Long id);
	
	boolean validateDuplicateMember(MemberVO membervo);  //중복검사

	 
	
	
}
