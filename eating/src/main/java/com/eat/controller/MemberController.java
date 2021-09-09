package com.eat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eat.service.MemberService;
import com.eat.vo.MemberVO;
import com.eat.web.Findidform;
import java.util.List;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberservice;

	@GetMapping("/")
	public String Test() {
		return "/main";
	}

	@GetMapping("/Login") // 로그인
	public void Login(Model model) {
		model.addAttribute("selectAll", memberservice.selectAll());
		List<MemberVO> memberList = memberservice.selectAll();
		System.out.println(memberList.size());
	}

	@GetMapping("/register") // 회원가입
	public String register() {
		return "register";
	}

	@PostMapping("insertMember") // 회원가입
	public String insertMember(MemberVO membervo) {
		System.out.println(membervo);
		memberservice.insertMember(membervo);
		return "redirect:/Login";
	}

	@GetMapping("/findid") // 아이디찾기
	public String findid(Model model) {
		model.addAttribute("selectMember", new Findidform());


		return "/findid";
	}

	@PostMapping("/findid")
	public String findidd(Findidform findidform) {
		MemberVO membervo = memberservice.selectMember(findidform.getUserName(), findidform.getPhoneNumber());
		
		return "{}";
	}

	@GetMapping("/findpw") // 비밀번호찾기
	public String findpw() {
		return "/findpw";
	}

	@GetMapping("logincheck") // 로그인 완료
	public String logincheck(MemberVO membervo) {
		System.out.println(membervo);
		return "/logindo";
	}

	public void updateMember(MemberVO membervo) { // 수정
		System.out.println(membervo);
		memberservice.updateMember(membervo);
	}

	public void deleteMember(MemberVO membervo) { // 삭제
		System.out.println(membervo);
		memberservice.deleteMember(membervo);
	}

	@GetMapping("/adminlogin") // 관리자 로그인
	public void adminLogin(Model model) {
		model.addAttribute("selectAll", memberservice.selectAll());
		List<MemberVO> memberList = memberservice.selectAll();
		System.out.println(memberList.size());
	}

	@GetMapping("/memberList")  //회원목록
	public void selectAll(Model model) {
		model.addAttribute("selectAll", memberservice.selectAll());
		List<MemberVO> memberList = memberservice.selectAll();
		System.out.println(memberList.size());
	}


}