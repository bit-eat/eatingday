package com.eat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.CategoryDAO;
import com.eat.dao.DietDAO;
import com.eat.vo.DietVO;

@Controller
public class DietController {
	@GetMapping("/")
	public String main() {
		return "dietMain";
	}
	@Autowired
	DietDAO dietDAO; 
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	public void insertDiet(DietVO dietVO) {
		
	}
	public void updateDiet(DietVO dietVO) {
		
	};
	public void deleteDiet(Long id) {
		
	};
	
	@GetMapping("/dietList")
	public void showDietList(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
	}

	public List<DietVO> selectDietList(Date date){
		return dietDAO.selectDietList(date);
	}
}