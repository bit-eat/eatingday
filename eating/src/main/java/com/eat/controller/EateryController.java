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


@Controller

public class EateryController {

	@Autowired
	private EateryService eateryservice;
	
	@Autowired
	private CategoryDAO categorydao;

	@GetMapping("/eateryTest")
	public void eateryTest(Model model) {
		model.addAttribute("selectAll",eateryservice.selectAll());
		System.out.println(model);
	}

	@GetMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("categoryList",categorydao.categoryList());
		return "/insert";
	}

	@PostMapping("/insertEatery")
	public String insertEatery(EateryVO eateryvo) {
		System.out.println(eateryvo);
		eateryservice.insertEatery(eateryvo);
		return "redirect:/eateryTest";
	}
	
	@GetMapping("/detail")
	public String detail(Model model) {
		String name = "유가";
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/detail";
	}
	@GetMapping("/eateryMain")
	public void eateryMain(Model model) {
		model.addAttribute("selectAll",eateryservice.selectAll());
		System.out.println(model);
	}
	@GetMapping("/menuEatery")
	public String menu(Model model) {
		String name = "유가";
		model.addAttribute("selectName",eateryservice.selectName(name));
		return "/menuEatery";
	}
	@GetMapping("/areaEatery")
	public String areaEatery(Model model) {
		String area = "GYEONGNAM";
		model.addAttribute("selectArea",eateryservice.selectArea(area));
		return "/areaEatery";
	}
}
