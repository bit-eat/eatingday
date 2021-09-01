package com.eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("/Test")
	public List<MemberVO> selectAll(Model model){
		System.out.println(memberservice.selectAll());
		model.addAttribute("selectAll", memberservice.selectAll());
		return memberservice.selectAll();
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";

	
}
}