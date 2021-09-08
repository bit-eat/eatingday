package com.eat.controller;

import com.eat.dao.RecipeDAO;
import com.eat.vo.RecipeVO;
import com.eat.web.RecipeForm;
import com.eat.web.RecipeTagForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeDAO recipeDAO;

    @GetMapping("/recipe")
    public String home(){
        return "/recipeMain";
    }

    @GetMapping(value="/recipe/new")
    public String createRecipe(Model model){
        model.addAttribute("recipeForm", new RecipeForm());
        return "/createRecipeForm";
    }

    @PostMapping(value="/recipe/new")
    @ResponseBody
    public String create(@Validated RecipeForm recipeForm,
                         @RequestParam(value="tagResult")List<RecipeTagForm> tagResult){
        RecipeVO recipe = new RecipeVO();
        recipe.setName(recipeForm.getName());
        recipe.setIngredient(recipeForm.getIngredient());
        recipe.setPeople(recipeForm.getPeople());
        recipe.setCreateDate(LocalDateTime.now());
        recipeDAO.insertRecipe(recipe);
        for(RecipeTagForm i : tagResult)
            System.out.println(i.getName());
        return "redirect:/";
    }

    @GetMapping(value="/recipeList")
    public String recipeList(Model model){
        List<RecipeVO> recipeList = recipeDAO.selectAll();
        model.addAttribute("recipeList",recipeList);
        return "/recipeList";
    }


}
