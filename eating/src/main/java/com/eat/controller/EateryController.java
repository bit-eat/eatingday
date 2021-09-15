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
	public String detail(Model model, String name) {
		
		model.addAttribute("selectName", eateryservice.selectName(name));
		return "/detail";
	}

	@PostMapping("recommend")
	public String Recommend(Long id) {
		System.out.println(id);
		eateryservice.updateEateryRecommend(id);
		return "redirect:/detail";
	}

	@GetMapping("/eateryMain")
	public void eateryMain(Model model,String area) {
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
	public String areaEateryMain(Model model,@RequestParam("area") String area) {
		
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
