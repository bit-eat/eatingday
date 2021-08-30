package com.eat.controller.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.suggestion.RandomDAO;
import com.eat.vo.suggestion.RandomVO;

@Controller
public class RandomController {
//	public RecipVO showRecipe(Long recipeId);
//	public EateryVO showEatery(Long eateryId);
	
	@Autowired
	private RandomDAO randomDAO;
	
	@GetMapping("/test")
	public List<RandomVO> getRecipe() {
		return RandomDAO.selectAll();
		
	@GetMapping("/test")
	public List<RandomVO> getEatery() {
		return RandomDAO.selectAll();
	}+
}
