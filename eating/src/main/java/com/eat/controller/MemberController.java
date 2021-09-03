package com.eat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.vo.MemberVO;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.eat.dao.MemberDAO;
import com.eat.service.MemberService;

@Controller
public class MemberController {
	
	
	@GetMapping("/")
	public String Test() {
		return "/main";
	}
	
	@Autowired
	private MemberService memberservice;
	//private MemberDAO memberdao;
	
	
	@Autowired
	
	public void insertMember(MemberService memberservice) {}
	public void updateMember(MemberService memberservice) {}
	public void deleteMember(MemberService memberservice) {}
	
	
/*	@RequestMapping(value ="/login",method=RequestMethod.POST)
	public String login(MemberVO vo,Model model) {
		System.out.println("vo="+vo);
		//MemberVO membervo = MemberService(vo.getUserId(),vo.getUserPw()); 
		return "test.html";
	}*/
	

	
	@GetMapping("/Login")
	public void selectAll(Model model){
		System.out.println(memberservice.selectAll());
		model.addAttribute("selectAll", memberservice.selectAll());
		if(model==null) {
			model.addAttribute("loginMessage","아이디 혹은 비밀번호가 일치하지 않습니다.");
			
		}
	}
	
	@GetMapping("/adminlogin")
	public void selectGrade(Model model){
		System.out.println(memberservice.selectGrade("grade"));
		model.addAttribute("selectGrade", memberservice.selectGrade("grade"));
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
		@GetMapping("/findid")
		public String login() {
			return "findid";
}
		@GetMapping("/findpw")
		public String findpw() {
			return "findpw";
}
}