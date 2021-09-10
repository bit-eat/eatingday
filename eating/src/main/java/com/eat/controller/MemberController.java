package com.eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.service.MemberService;

@Controller
public class MemberController {

	@GetMapping("/member")
	public String Test() {
		return "dietMain";
	}

	@Autowired
	private MemberService memberservice;
	// private MemberDAO memberdao;


	public void insertMember(MemberService memberservice) {
	}

	public void updateMember(MemberService memberservice) {
	}

	public void deleteMember(MemberService memberservice) {
	}

	/*
	 * @RequestMapping(value ="/login",method=RequestMethod.POST) public String
	 * login(MemberVO vo,Model model) { System.out.println("vo="+vo); //MemberVO
	 * membervo = MemberService(vo.getUserId(),vo.getUserPw()); return "test.html";
	 * }
	 */

	@GetMapping("/Login")
	public void selectAll(Model model) {
		System.out.println(memberservice.selectAll());
		model.addAttribute("selectAll", memberservice.selectAll());
		if (model == null) {
			model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");

		}
	}

	@GetMapping("/adminlogin")
	public void selectGrade(Model model) {
		System.out.println(memberservice.selectGrade("grade"));
		model.addAttribute("selectGrade", memberservice.selectGrade("grade"));
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/findid")
	public String findid(){
		return "/findid";
	}
	
	@PostMapping("findId")
	public void findId(Model model, @RequestParam("userName")String userName,@RequestParam("phoneNumber") String phoneNumber) {
		model.addAttribute("findId",memberservice.findId(userName, phoneNumber));
		System.out.println(model);
	}

	@GetMapping("/findpw")
	public String findpw() {
		return "findpw";
	}
	
}