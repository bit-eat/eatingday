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
	public void insertMember(MemberVO membervo) {
		if (validateDuplicateMember(membervo)) {
			memberdao.insertMember(membervo);
		}
		// TODO Auto-generated method stub
		throw new IllegalStateException("이미 존재하는 아이디입니다.");
	}

	@Override
	public void updateMember(MemberVO membervo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(MemberVO membervo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberVO> findId(String userName, String phoneNumber) {
		return memberdao.findId(userName, phoneNumber);
	}

	@Override
	public MemberVO selectMember(String userName, String phoneNumber) {
		// TODO Auto-generated method stub
		return memberdao.selectMember(userName, phoneNumber);
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return memberdao.selectAll();
	}

	@Override
	public MemberVO selectOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectGrade(String grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectMemberId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateDuplicateMember(MemberVO membervo) {
		// TODO Auto-generated method stub
		MemberVO member = memberdao.selectMemberId(membervo.getUserId());
		if (member == null) {
			return true; // 중복 아님
		}
		return false;
	}

	@Override
	public List<MemberVO> findPw(String userName, String phoneNumber, String userId) {
		// TODO Auto-generated method stub
		return memberdao.findPw(userName, userId, phoneNumber);
	}

}
