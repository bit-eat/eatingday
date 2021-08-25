package com.eat.controller;

import com.eat.dao.RecipeDAO;
import com.eat.vo.RecipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeDAO recipeDAO;

    @GetMapping("/test")
    public List<RecipeVO> getRecipe(){
        return recipeDAO.selectAll();
    }

}
