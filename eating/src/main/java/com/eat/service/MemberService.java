package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

public interface MemberService {

	void insertMember(MemberVO membervo);

	void updateMember(MemberVO membervo);

	void deleteMember(MemberVO membervo);

	MemberVO selectMember(String userName, String phoneNumber);

	List<MemberVO> selectAll();

	MemberVO selectOne(Long id);

	List<MemberVO> selectGrade(String grade);

	List<MemberVO> selectMemberId(Long id);

	List<MemberVO> findId(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber);

	List<MemberVO> findPw(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber,
			@Param("userId") String userId);

	boolean validateDuplicateMember(MemberVO membervo); // 중복검사

}
