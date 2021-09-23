package com.eat.controller;

import java.time.LocalDate;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.dao.CategoryDAO;
import com.eat.dao.DietDAO;
import com.eat.vo.DietVO;

@Controller
public class DietController {
	
//	@GetMapping("/")
//	public String main() {
//		return "/suggestion/dietList";
//
//	}
	
	@Autowired
	DietDAO dietDAO; 
	
	@Autowired
	CategoryDAO categoryDAO;

	@GetMapping("/suggestion/ladder")
	public String ladder() {
		return "/suggestion/ladder";
	}
	
	@PostMapping("/suggestion/selectDietList")
	public String selectDietList(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")LocalDate date,
								@RequestParam("date2")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")LocalDate date2, Model model) {
		model.addAttribute( "selectDietList"  , dietDAO.selectDietList(date, date2));
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
		return "/suggestion/dietList";
	}
	
	@GetMapping("/suggestion/dietMain")
	public void showDietListMain(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
	}
	
	@GetMapping("/suggestion/dietList")
	public void showDietList(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
	}

	@GetMapping("count")
	public String countDietList(DietVO dietVO,Model model) {
		model.addAttribute("counting",dietDAO.countDietList(dietVO));
		System.out.println(model);
		return "/suggestion/insertDiet";
	}
	
	@PostMapping("/suggestion/insertDiet")
	public String insertDiet(DietVO dietVO) {
		dietDAO.insertDiet(dietVO);
		
		return "redirect:/suggestion/dietList";
	}
	
	@PostMapping("/suggestion/updateDiet")
	public String updateDiet(DietVO dietVO) {
		dietDAO.updateDiet(dietVO);
		return "redirect:/suggestion/dietList";
	};
	
	@PostMapping("/suggestion/deleteDiet")
	public String deleteDiet(DietVO dietVO) {
		dietDAO.deleteDiet(dietVO);
		return "redirect:/suggestion/dietList";
	};
	

}