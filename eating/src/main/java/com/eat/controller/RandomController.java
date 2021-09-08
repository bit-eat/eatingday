package com.eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.EateryDAO;
import com.eat.dao.RandomDAO;
import com.eat.dao.RecipeDAO;
import com.eat.vo.RandomVO;

@Controller
public class RandomController {
	
	@Autowired
	RandomDAO randomDAO;
	
	@Autowired
	EateryDAO eateryDAO;
	
	@Autowired
	RecipeDAO recipeDAO;
	
	@GetMapping("/suggestion/randomList")
	public void showRandom(Model model, Model model2) {
		Long en = (long) (Math.random()*(eateryDAO.selectAll().toArray().length-1)+1);
		model.addAttribute("showEatery", randomDAO.showEatery(en));
		
		Long rn = (long) (Math.random()*(recipeDAO.selectAll().toArray().length-1)+1);
		model2.addAttribute("showRecipe", randomDAO.showRecipe(rn));
	}
	
//	@GetMapping("/suggestion/randomList")
//	public void showRecipe(Model model) {
//		Long a = (long) 1;
//	}
	
}