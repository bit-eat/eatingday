package com.eat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.EateryBookmarkDAO;
import com.eat.vo.MemberVO;

@Controller
public class EateryBookmarkController {
	@Autowired
	private EateryBookmarkDAO eateryBookmarkdao;

	@GetMapping("/eateryBookmarkList")
	public String eateryBookmarkList(Model model, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("selectEateryBookmark",eateryBookmarkdao.selectEateryBookmark(member.getId()));
		return "/eateryBookmarkList";
	}
}
