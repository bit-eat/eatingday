package com.eat.controller;

import com.eat.dao.CategoryDAO;
import com.eat.service.EateryService;
import com.eat.vo.Area;
import com.eat.vo.EateryVO;

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
	public String detailMain(Model model,String name, Long id) {
		System.out.println("dm id :"+id+" dm name :"+name);
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		model.addAttribute("selectName", eateryservice.selectName(name));
		return "/detail";
	}

	@PostMapping("detail")
	public String detail(Model model,String name) {
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}

	@PostMapping("recommend")
	public String Recommend(Model model,Long id,Long memberid,String name) {
		memberid = (long) 1;
		eateryservice.insertMemberRecommend(id, memberid);
		eateryservice.updateEateryRecommend(id);
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		model.addAttribute("selectId",eateryservice.selectId(id));
		return "/detail";
	}
	@PostMapping("unrecommend")
	public String Unrecommend(Model model,Long id, Long memberid, String name) {
		memberid = (long) 1;
		eateryservice.updateEateryUnrecommend(id);
		eateryservice.deleteMemberRecommend(id,memberid);
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}
	@PostMapping("bookmark")
	public String Bookmark(Model model,Long id,Long memberid,String name) {
		System.out.println("re id :"+id+" re name :"+name);
		memberid = (long) 1;
		eateryservice.insertEateryBookmark(id, memberid);
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
		model.addAttribute("selectName",eateryservice.selectName(name));
		
		return "/detail";
	}
	@PostMapping("unbookmark")
	public String UnBookmark(Model model,Long id, Long memberid, String name) {
		System.out.println("ur id :"+id+" ur memberid :"+memberid+" ur name :"+name);
		memberid = (long) 1;
		eateryservice.deleteEateryBookmark(id,memberid);
		EateryVO eateryvo = new EateryVO();
		eateryvo.setMemberId((long) 1);
		eateryvo.setName(name);
		model.addAttribute("checkid",eateryservice.checkid(eateryvo));
		model.addAttribute("checkingid",eateryservice.checkingid(eateryvo));
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
		if (checking.equals("추천순")) {
			model.addAttribute("RecommendEateryList", eateryservice.RecommendEateryList());
			return "/eateryMain";
		} else if (checking.equals("최신순")) {
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
