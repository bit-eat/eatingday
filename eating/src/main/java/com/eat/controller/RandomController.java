package com.eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.EateryDAO;
import com.eat.dao.RandomDAO;
import com.eat.dao.RecipeDAO;
import com.eat.vo.EateryVO;
import com.eat.vo.RecipeVO;

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
		int en = (int) (Math.random()*(eateryDAO.selectAll().toArray().length));
	      List<EateryVO> eateryVO = eateryDAO.selectAll();
	      model.addAttribute("showEatery", randomDAO.showEatery(eateryVO.get(en).getId()));
	      
	      int rn = (int) (Math.random()*(recipeDAO.selectAll().toArray().length));
	      List<RecipeVO> recipeVO = recipeDAO.selectAll();
	      model.addAttribute("showRecipe", randomDAO.showRecipe(recipeVO.get(rn).getId()));
	}
}