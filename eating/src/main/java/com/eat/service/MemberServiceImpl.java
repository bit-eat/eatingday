package com.eat.service;

import java.lang.reflect.Member;
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
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> selectOne(Long id) {
		// TODO Auto-generated method stub
		return memberdao.selectOne(id);
	}

	@Override
	public List<MemberVO> selectGrade(String grade) {
		// TODO Auto-generated method stub
		return memberdao.selectGrade(grade);
	}

	@Override
	public List<MemberVO> selectMemberId(Long id) {
		// TODO Auto-generated method stub
		return memberdao.selectMemberId(id);
	}

	@Override
	public boolean validateDuplicateMember(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return memberdao.selectAll();
	}

	@Override
	public List<MemberVO> findId(String userName, String phoneNumber) {
		return memberdao.findId(userName,phoneNumber);
	}

	
	

}
