package com.eat.controller;

import com.eat.dao.RecipeDAO;
import com.eat.dao.RecipeSearch;
import com.eat.service.RecipeService;
import com.eat.vo.RecipeContentVO;
import com.eat.vo.RecipeVO;
import com.eat.web.RecipeForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeDAO recipeDAO;
    private final RecipeService recipeService;

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
    public String create(@Validated RecipeForm recipeForm){
        RecipeVO recipe = new RecipeVO();
        recipe.setThumb("/img/" + recipeForm.getThumb());
        recipe.setName(recipeForm.getName());
        recipe.setIngredient(recipeForm.getIngredient());
        recipe.setPeople(recipeForm.getPeople());
        recipe.setCreateDate(LocalDateTime.now());

        Long recipeId = recipeService.saveRecipe(recipe);
        recipeService.manufactureTag(recipeId, recipeForm.getOriginTag());
        recipeService.tempSaveContent(recipeId,recipeForm.getContent());

        return "redirect:/";
    }

    @GetMapping(value="/recipeList")
    public String recipeList(@ModelAttribute("recipeSearch")RecipeSearch recipeSearch, Model model){
        List<RecipeVO> recipeList = recipeService.selectStatus(recipeSearch.getStatus(), recipeSearch.getSearchName());
        model.addAttribute("recipeList", recipeList);
        return "/recipeList";
    }

    @PostMapping("recipe/{recipeId}/delete")
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId){
        recipeService.deleteRecipe(recipeId);
        return "redirect:/recipeList";
    }

    @GetMapping("recipe/{recipeId}/edit")
    public String updateRecipeForm(@PathVariable("recipeId")Long recipeId, Model model){
        RecipeVO recipeVO = recipeService.selectOne(recipeId);
        String tagList = recipeService.combineTag(recipeId);
        RecipeContentVO recipeContentVO = recipeService.selectContent(recipeId);
        String content = "";

        if(recipeContentVO != null)
            content = recipeContentVO.getContent();

        RecipeForm form = new RecipeForm();
        form.setThumb(recipeVO.getThumb());
        form.setName(recipeVO.getName());
        form.setIngredient(recipeVO.getIngredient());
        form.setPeople(recipeVO.getPeople());
        form.setOriginTag(tagList);
        form.setContent(content);

        model.addAttribute("form",form);
        return "updateRecipe";

    }

    @GetMapping("recipe/{recipeId}/detail")
    public String detailRecipe(@PathVariable("recipeId")Long recipeId, Model model){
        RecipeVO recipeVO = recipeDAO.selectOne(recipeId);
        String tagList = recipeService.combineTag(recipeId);
        RecipeContentVO recipeContentVO = recipeService.selectContent(recipeId);
        String content = "";

        if(recipeContentVO != null)
            content = recipeContentVO.getContent();

        RecipeForm form = new RecipeForm();
        form.setThumb(recipeVO.getThumb());
        form.setName(recipeVO.getName());
        form.setIngredient(recipeVO.getIngredient());
        form.setPeople(recipeVO.getPeople());
        form.setOriginTag(tagList);
        form.setContent(content);

        model.addAttribute("form",form);

        return "recipeDetail";

    }

    @PostMapping("recipe/{recipeId}/edit")
    public String updateRecipe(@PathVariable("recipeId")Long recipeId, @ModelAttribute("form") RecipeForm form){
        RecipeVO recipeVO = recipeDAO.selectOne(recipeId);
        String originImg = recipeVO.getThumb().substring(5);

        if(form.getThumb() != "")
        {
            originImg = form.getThumb();
        }

        recipeService.updateRecipe(recipeId,form.getName(), originImg,
                form.getIngredient(),form.getPeople(),form.getOriginTag(),form.getContent());

        return "redirect:/recipeList";
    }


}
