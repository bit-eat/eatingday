package com.eat.dao;

import com.eat.vo.MemberVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberDAOTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void create() {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserName("김세은");
		memberVO.setUserId("kim");
		memberVO.setUserPw("123");
		memberVO.setPhoneNumber("01076668900");
		
		
		memberDAO.insertMember(memberVO);
		
	}
}
