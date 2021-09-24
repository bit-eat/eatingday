package com.eat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eat.dao.MemberDAO;
import com.eat.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberdao;

	@Override
	public void insertMember(MemberVO membervo) { // 아이디 중복 검사
		memberdao.insertMember(membervo);
	}

	@Override
	public void updateMember(MemberVO membervo) { // 개인정보수정
		memberdao.updateMember(membervo);
	}

	@Override
	public void deleteMember(MemberVO membervo) { // 회원탈퇴
		memberdao.deleteMember(membervo);
	}

	@Override
	public void admindelete(MemberVO membervo) { // 회원탈퇴
		memberdao.deleteMember(membervo);
	}

	@Override
	public MemberVO findId(String userName, String phoneNumber) { // 아이디찾기
		return memberdao.findId(userName, phoneNumber);
	}

	@Override
	public MemberVO selectMember(String userName, String phoneNumber) {
		return memberdao.selectMember(userName, phoneNumber);
	}

	@Override
	public List<MemberVO> selectAll() { // 회원목록
		return memberdao.selectAll();
	}

	@Override
	public List<MemberVO> selectGrade(String grade) {

		return null;
	}

	@Override
	public MemberVO selectOne(String userId) {
		return memberdao.selectOne(userId);
	}

	@Override
	public MemberVO selectMemberId(String userId) {
		return memberdao.selectMemberId(userId);
	}

	@Override
	public boolean validateDuplicateMember(MemberVO membervo) { // 중복검사
		MemberVO member = memberdao.selectMemberId(membervo.getUserId());
		if (member == null) {
			return true; // 중복 아님
		}
		return false;
	}

	@Override
	public List<MemberVO> findPw(String userName, String phoneNumber, String userId) { // 비밀번호찾기
		return memberdao.findPw(userName, phoneNumber, userId);
	}

	@Override

	public int logincheck(String userId, String userPw) { // 로그인

		return memberdao.logincheck(userId, userPw);
	}

	@Override
	public int admincheck(String userId, String userPw) { // 관리자 로그인

		return memberdao.admincheck(userId, userPw);
	}

	@Override
	public void deletecheck(List<Long> id) { // 관리자 회원 관리
		memberdao.deletecheck(id);
	}

	@Override
	public void updateMemberList(MemberVO membervo) { // 관리자 회원 수정
		memberdao.updateMemberList(membervo);
	}

	@Override
	public void adminEateryDelete(List<Long> id) { // 관리자 음식점 게시판 삭제
		// TODO Auto-generated method stub
		memberdao.adminEateryBookmarkDelete(id);
		memberdao.adminEateryRecommendDelete(id);
		memberdao.adminMemberRecommendDelete(id);
		memberdao.adminEateryDelete(id);
	}

	@Override
	public void adminRecipedelete(List<Long> id) { // 관리자 레시피 게시판 삭제
		// TODO Auto-generated method stub
		memberdao.adminRecipeBookmarkDelete(id);
		memberdao.adminRecipedelete(id);
	}
}
