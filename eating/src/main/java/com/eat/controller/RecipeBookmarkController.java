package com.eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.EateryBookmarkDAO;
import com.eat.dao.RecipeBookmarkDAO;

@Controller
public class RecipeBookmarkController {
	@Autowired
	private RecipeBookmarkDAO recipeBookmarkdao;

	@GetMapping("/recipeBookmarkList")
	public String recipeBookmarkList(Model model, Long id) {
		id=(long) 1;
		model.addAttribute("selectRecipeBookmark",recipeBookmarkdao.selectRecipeBookmark(id));
		return "/recipeBookmarkList";
	}
}
