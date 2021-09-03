package com.eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.dao.CategoryDAO;
import com.eat.dao.DietDAO;
import com.eat.vo.CategoryVO;
import com.eat.vo.DietVO;

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
	public void deleteDiet(Long id) {
		
	};
	
	@GetMapping("/dietList")
	public void showDietList(Model model){
		model.addAttribute( "showDietList"  , dietDAO.showDietList());
		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
		System.out.println(categoryDAO.categoryList());
	}

	@PostMapping("insertDiet")
	public String insertDiet(DietVO dietVO) {
		CategoryVO categoryVO = new CategoryVO();
		System.out.println(categoryVO.getId());
		System.out.println(dietVO.getCategoryId());
		dietDAO.insertDiet(dietVO);
		return "redirect:/dietList";
	}

//	public List<DietVO> selectDietList(Date date){
//		return dietDAO.selectDietList(date);
//	}
}