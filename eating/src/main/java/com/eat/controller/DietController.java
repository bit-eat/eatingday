package com.eat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eat.dao.CategoryDAO;
import com.eat.dao.DietDAO;
import com.eat.vo.DietVO;
import com.eat.vo.Meal;

@Controller
public class DietController {
	@GetMapping("/")
	public String main() {
		return "/main";
	}
	@Autowired
	DietDAO dietDAO; 
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public void updateDiet(DietVO dietVO) {
		
	};
	
	@PostMapping("deleteDiet")
	public String deleteDiet(DietVO dietVO) {
		System.out.println(dietVO.getDate()+""+dietVO.getMeal());
		dietDAO.deleteDiet(dietVO);
		return "redirect:/dietList";
	};
	
	@GetMapping("/dietList")
	public void showDietList(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
	}

	@PostMapping("insertDiet")
	public String insertDiet(DietVO dietVO) {
		System.out.println(dietVO);
		dietDAO.insertDiet(dietVO);
		return "redirect:/dietList";
	}

//	public List<DietVO> selectDietList(Date date){
//		return dietDAO.selectDietList(date);
//	}
}