package com.eat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.eat.dao.DietDAO;
import com.eat.vo.DietVO;

@Controller
public class DietController {
	DietDAO dietDAO; 
	public void insertDiet(DietVO dietVO) {

	}
	public void updateDiet(DietVO dietVO) {
		
	};
	public void deleteDiet(DietVO dietVO) {
		
	};
	
	public List<DietVO> showDietList(){
		return dietDAO.showDietList();
	}
	
	public List<DietVO> selectDietList(Date date){
		return dietDAO.selectDietList(date);
	}
}
