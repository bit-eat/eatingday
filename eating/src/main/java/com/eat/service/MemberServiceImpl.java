package com.eat.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eat.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

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
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectOne(Long id) {
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
	public boolean validateDuplicateMember(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
