package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eat.vo.MemberVO;

@Mapper
public interface MemberDAO {

	void insertMember(MemberVO membervo);  //(생성)회원가입

	void updateMember(MemberVO membervo);  //(수정)개인정보수정

	void deleteMember(MemberVO membervo);  //(삭제)회원탈퇴

	MemberVO selectMember(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber);

	List<MemberVO> selectAll();  //모든 회원 목록

	List<MemberVO> findId(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber);   //아이디찾기
	
	int logincheck(@Param("userId") String userId, @Param("userPw") String userPw);   //로그인

	List<MemberVO> findPw(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber,   //비밀번호찾기
			@Param("userId") String userId);

	MemberVO selectOne(@Param("id") Long id);

	List<MemberVO> selectGrade(@Param("grade") String grade);

	MemberVO selectMemberId(@Param("userId") String userId);

}
