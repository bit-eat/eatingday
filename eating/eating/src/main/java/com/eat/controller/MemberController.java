package com.eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.vo.MemberVO;
import com.eat.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@GetMapping("/")
	public String Test() {
		return "/Test";
	}
	
	@GetMapping("/Test")
	public List<MemberVO> getMember(){
		System.out.println(memberservice.selectAll());
		return memberservice.selectAll();
		}
	
	@GetMapping("/main")
		public String main() {
			return "main";
}
	
}
