package com.eat.controller;

import com.eat.service.EateryService;
import com.eat.vo.EateryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class EateryController {

	@Autowired
	private EateryService eateryservice;

	@GetMapping("/eateryTest")
	public String eateryTest() {
		return "/eateryTest";
	}

	@GetMapping("/insert")
	public String insert() {
		return "/insert";
	}

	@PostMapping("insertEatery")
	public void insertEatery(EateryVO eateryvo) {
		System.out.println(eateryvo);
		eateryservice.insertEatery(eateryvo);
	}

	@RequestMapping(value = "/insertPost")
	public void selectAll(Model model) {
		System.out.println(eateryservice.selectAll());
		model.addAttribute("selectAll", eateryservice.selectAll());

	}

}