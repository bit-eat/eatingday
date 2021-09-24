package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

@Mapper
public interface MemberDAO {

	void insertMember(MemberVO membervo); // (생성)회원가입

	void updateMember(MemberVO membervo); // (수정)개인정보수정

	void deleteMember(MemberVO membervo); // (삭제)회원탈퇴

	void admindelete(MemberVO membervo); // 관리자 회원 삭제

	MemberVO selectMember(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber);

	List<MemberVO> selectAll(); // 모든 회원 목록

	MemberVO findId(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber); // 아이디찾기

	int logincheck(@Param("userId") String userId, @Param("userPw") String userPw); // 로그인

	int admincheck(@Param("userId") String userId, @Param("userPw") String userPw); // 관리자 로그인

	List<MemberVO> findPw(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber, // 비밀번호찾기
			@Param("userId") String userId);

	List<MemberVO> selectGrade(@Param("grade") String grade); // 관리자만

	MemberVO selectOne(@Param("userId") String userId);

	MemberVO selectMemberId(@Param("userId") String userId);

	void deletecheck(@Param("id") List<Long> id); // 관리자 회원 관리

	void updateMemberList(MemberVO membervo); // 관리자 회원 수정

	void adminRecipedelete(@Param("id") List<Long> id); // 관리자 레시피 게시판 관리

	void adminRecipeBookmarkDelete(@Param("id") List<Long> id); // 관리자 레시피 게시판 관리

	void adminEateryDelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제

	void adminEateryRecommendDelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제

	void adminEateryBookmarkDelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제

	void adminMemberRecommendDelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제
}
