package com.eat.controller;

import com.eat.dao.CategoryDAO;
import com.eat.service.EateryService;
import com.eat.vo.Area;
import com.eat.vo.EateryVO;
import com.eat.vo.MemberVO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class EateryController {

	@Autowired
	private EateryService eateryservice;

	@Autowired
	private CategoryDAO categorydao;

	@GetMapping("/eateryList")
	public void eateryList(Model model) {
		model.addAttribute("selectAll", eateryservice.selectAll());
		System.out.println(model);
	}

	@GetMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("categoryList", categorydao.categoryList());
		return "/insert";
	}

	@PostMapping("/insertEatery")
	public String insertEatery(EateryVO eateryvo) {
		eateryservice.insertEatery(eateryvo);
		return "redirect:/eateryList";
	}

	@GetMapping("/detail")
	public String detailMain(Model model,String name,HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(null!=member) {
			eateryvo.setMemberId(member.getId());
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectName", eateryservice.selectName(name));
		return "/detail";
	}

	@PostMapping("detail")
	public String detail(Model model,String name,HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(null!=member) {
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}

	@PostMapping("recommend")
	public String Recommend(Model model,Long id,HttpSession session,String name) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(null!=member) {
		eateryservice.insertMemberRecommend(id, member.getId());
		eateryservice.updateEateryRecommend(id);
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectId",eateryservice.selectId(id));
		return "/detail";
	}
	@PostMapping("unrecommend")
	public String Unrecommend(Model model,Long id, HttpSession session, String name) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(null!=member) {
		eateryservice.deleteMemberRecommend(id,member.getId());
		eateryservice.updateEateryUnrecommend(id);
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}
	@PostMapping("bookmark")
	public String Bookmark(Model model,Long id,HttpSession session,String name) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(!member.equals(null)) {
		eateryservice.insertEateryBookmark(id, member.getId());
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectName",eateryservice.selectName(name));
		
		return "/detail";
	}
	@PostMapping("unbookmark")
	public String UnBookmark(Model model,Long id, HttpSession session, String name) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		EateryVO eateryvo = new EateryVO();
		eateryvo.setName(name);
		if(null!=member) {	
		eateryservice.deleteEateryBookmark(id,member.getId());
		eateryvo.setMemberId(member.getId());
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		}
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}
	
	@GetMapping("/eateryMain")
	public void eateryMain(Model model, String area) {
		model.addAttribute("selectAll", eateryservice.selectAll());
		model.addAttribute("selectArea", eateryservice.selectArea(area));
	}

	@PostMapping("selectEateryList")
	public String selectEateryList(Model model, String checking) {
		if (checking.equals("?????????")) {
			model.addAttribute("RecommendEateryList", eateryservice.RecommendEateryList());
			return "/eateryMain";
		} else if (checking.equals("?????????")) {
			model.addAttribute("LatestEateryList", eateryservice.LatestEateryList());
			return "/eateryMain";
		} else {
			return "/eateryMain";
		}
	}

	@GetMapping("/menuEatery")
	public void menuEateryMain(Model model) {
		model.addAttribute("selectAll", eateryservice.selectAll());
		model.addAttribute("selectRecommend", eateryservice.selectRecommend());
	}

	@GetMapping("selectMenuEatery")
	public String menuEateryMain(Model model, @RequestParam("categoryName") String categoryName) {

		model.addAttribute("selectCategoryName", eateryservice.selectCategoryName(categoryName));
		model.addAttribute("selectRecommendCategory", eateryservice.selectCategoryRecommend(categoryName));
		return "/menuEatery";
	}

	@PostMapping("menuEatery")
	public String menuEatery(Model model, String categoryName) {
		model.addAttribute("selectRecommendCategory", eateryservice.selectCategoryRecommend(categoryName));
		model.addAttribute("selectCategoryName", eateryservice.selectCategoryName(categoryName));
		return "/menuEatery";
	}

	@GetMapping("/areaEatery")
	public void areaEateryMain(Model model) {
		model.addAttribute("selectAll", eateryservice.selectAll());
		model.addAttribute("selectRecommend", eateryservice.selectRecommend());
	}

	@GetMapping("selectAreaEatery")
	public String areaEateryMain(Model model, @RequestParam("area") String area) {

		model.addAttribute("selectArea", eateryservice.selectArea(area));
		model.addAttribute("selectRecommendArea", eateryservice.selectAreaRecommend(area));
		return "/areaEatery";
	}

	@PostMapping("areaEatery")
	public String areaEatery(Model model, String area) {
		model.addAttribute("selectRecommendArea", eateryservice.selectAreaRecommend(area));
		model.addAttribute("selectArea", eateryservice.selectArea(area));
		return "/areaEatery";
	}
}
