package com.eat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.dao.EateryBookmarkDAO;
import com.eat.service.MemberService;
import com.eat.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberservice;

	@Autowired
	private EateryBookmarkDAO eateryBookmarkdao;

	@GetMapping("/Login") // 로그인
	public void Login() {
	}

	@GetMapping("/mypage")    // 마이페이지
	public void mypage() {
	}

	@GetMapping("/register") 
	public String register() {       // 회원가입창띄우기
		return "register";
	}

	@PostMapping("insertMember") 
	public String insertMember(MemberVO membervo) {        // 회원가입
		System.out.println(membervo);
		memberservice.insertMember(membervo);
		return "/Login";
	}

	@GetMapping("/findid")           // 아이디찾기
	public String findid() {
		return "/findid";
	}

	@PostMapping("findId")             // 아이디찾기
	public void findId(Model model, @RequestParam("userName") String userName, 
			@RequestParam("phoneNumber") String phoneNumber) {
		model.addAttribute("findId", memberservice.findId(userName, phoneNumber));
		System.out.println(model);
	}

	@GetMapping("/findpw") 
	public String findpw() {       // 비밀번호찾기
		return "/findpw";
	}

	@PostMapping("/findPw")                   // 비밀번호찾기
	public void findPw(Model model, @RequestParam("userName") String userName, @RequestParam("userId") String userId,
			@RequestParam("phoneNumber") String phoneNumber) {
		model.addAttribute("findPw", memberservice.findPw(userName, phoneNumber, userId));
	}

	@PostMapping("logincheck") 
	public String logincheck(Model model, String userId, String userPw) {           // 로그인 완료 ->메인페이지로 띄우기
		model.addAttribute("logincheck", memberservice.logincheck(userId, userPw));
		int check = memberservice.logincheck(userId, userPw);
		if (check == 1) {
			return "redirect:/";
		} else {
			return "/Login";
		}
	}

	@PostMapping("admincheck") 
	public String admincheck(Model model, String userId, String userPw) {                  // 관리자 로그인 
		model.addAttribute("admincheck", memberservice.admincheck(userId, userPw));
		int check = memberservice.admincheck(userId, userPw);
		if (check == 1) {
			return "redirect:/memberList";
		} else {
			return "/adminlogin";
		}
	}

	@GetMapping("update")
	public String update(MemberVO membervo) {     // 수정(개인정보수정)
		System.out.println(membervo);
		memberservice.updateMember(membervo);
		return "update";
	}

	@PostMapping("update")
	public void updateMember(MemberVO membervo) { // 수정(개인정보수정)
		System.out.println(membervo);
		memberservice.updateMember(membervo);
	}

	@GetMapping("/delete") 
	public String delete() {   // 회원탈퇴 ,페이지 불러오기
		return "delete";
	}

	@PostMapping("/delete")
	public String deleteMember(MemberVO membervo) { // 삭제(회원탈퇴) , 정보전달 받은거 처리하기
		memberservice.deleteMember(membervo);
		return "/Login";
	}

	@GetMapping("/adminlogin") 
	public String adminLogin(MemberVO membervo) {   // 관리자 로그인
		System.out.println(membervo);
		return "/adminlogin";
	}

	@GetMapping("/memberList") 
	public void selectAll(Model model) {   // 회원 목록 불러오기
		model.addAttribute("selectAll", memberservice.selectAll());
	}

	@PostMapping("deletecheck") // 관리자 회원 관리
	public String deletecheck(@RequestParam("id") List<Long> id) {
		memberservice.deletecheck(id);
		return "redirect:/memberList";
	}
}