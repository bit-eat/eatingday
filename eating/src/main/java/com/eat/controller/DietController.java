package com.eat.controller;

import java.time.LocalDate;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
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
import com.eat.vo.Meal;

@Controller
public class DietController {
	
	@GetMapping("/")
	public String main() {
		return "/dietList";
	}
	
	@Autowired
	DietDAO dietDAO; 
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@PostMapping("selectDietList")
	public String selectDietList(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")LocalDate date,
								@RequestParam("date2")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")LocalDate date2, Model model) {
		model.addAttribute( "selectDietList"  , dietDAO.selectDietList(date, date2));
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
		return "dietList";
	}
	
	@GetMapping("/dietList")
	public void showDietList(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		System.out.println(model);
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
	}

	@PostMapping("insertDiet")
	public String insertDiet(DietVO dietVO) {
		System.out.println(dietVO);
		dietDAO.insertDiet(dietVO);
		return "redirect:/dietList";
	}
	
	@PostMapping("updateDiet")
	public String updateDiet(DietVO dietVO) {
		dietDAO.updateDiet(dietVO);
		return "redirect:/dietList";
	};
	
	@PostMapping("deleteDiet")
	public String deleteDiet(DietVO dietVO) {
		dietDAO.deleteDiet(dietVO);
		return "redirect:/dietList";
	};
	

}