package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

public interface MemberService {


	void insertMember(MemberVO membervo); // 회원가입

	void updateMember(MemberVO membervo); // 회원수정

	void deleteMember(MemberVO membervo); // 회원탈퇴
	
	void admindelete(MemberVO membervo); // 관리자 회원 삭제

	MemberVO selectMember(String userName, String phoneNumber);

	int logincheck(@Param("userId") String userId, @Param("userPw") String userPw); // 로그인

	int admincheck(@Param("userId") String userId, @Param("userPw") String userPw); //관리자 로그인

	List<MemberVO> selectAll();  //사용자 목록 다 가져오기

	MemberVO selectOne(Long id);

	List<MemberVO> selectGrade(String grade);  //관리자

	List<MemberVO> selectMemberId(Long id);

	List<MemberVO> findId(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber); // 아이디찾기

	List<MemberVO> findPw(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber, // 비밀번호찾기
			@Param("userId") String userId);

	boolean validateDuplicateMember(MemberVO membervo); // 중복검사

	void deletecheck(@Param("id")List<Long> id);   //관리자 회원 관리
	
	void updateMemberList(MemberVO membervo);  //관리자 회원 수정
}
