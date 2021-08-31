package com.eat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.dao.DietDAO;
import com.eat.vo.DietVO;

@Controller
public class DietController {
	@GetMapping("/")
	public String main() {
		return "/main";
	}
	@Autowired
	DietDAO dietDAO; 

	public void insertDiet(DietVO dietVO) {
		
	}
	public void updateDiet(DietVO dietVO) {
		
	};
	public void deleteDiet(DietVO dietVO) {
		
	};
	
	@GetMapping("/main")
	public List<DietVO> showDietList(){
		System.out.println(dietDAO.showDietList());
		return dietDAO.showDietList();
	}

	public List<DietVO> selectDietList(Date date){
		return dietDAO.selectDietList(date);
	}
}
