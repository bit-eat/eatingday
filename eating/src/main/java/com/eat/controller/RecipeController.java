package com.eat.controller;

import com.eat.dao.RecipeDAO;
import com.eat.dao.RecipeSearch;
import com.eat.service.RecipeService;
import com.eat.vo.MemberVO;
import com.eat.vo.RecipeContentVO;
import com.eat.vo.RecipeVO;
import com.eat.web.RecipeForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
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
    public String createRecipe(Model model, HttpSession httpSession){
        Object member = httpSession.getAttribute("member");
        if(member==null){
            System.out.println("회원정보 없음");
            return "redirect:/";
        }
        model.addAttribute("recipeForm", new RecipeForm());
        return "/createRecipeForm";
    }

    @PostMapping(value="/recipe/new")
    @ResponseBody
    public String create(@Validated RecipeForm recipeForm, @RequestPart("file") MultipartFile file){

        RecipeVO recipe = new RecipeVO();
        recipe.setThumb("/img/" + recipeForm.getThumb());
        recipe.setName(recipeForm.getName());
        recipe.setIngredient(recipeForm.getIngredient());
        recipe.setPeople(recipeForm.getPeople());
        recipe.setCreateDate(LocalDateTime.now());

        System.out.println("originName : " + file.getOriginalFilename());

        Long recipeId = recipeService.saveRecipe(recipe);
        recipeService.manufactureTag(recipeId, recipeForm.getOriginTag());
        recipeService.tempSaveContent(recipeId,recipeForm.getContent());

        return "redirect:/recipe/" + recipeId + "/detail";
    }

    @GetMapping(value="/recipeList")
    public String recipeList(@ModelAttribute("recipeSearch")RecipeSearch recipeSearch, Model model, HttpSession httpSession){
        List<RecipeVO> recipeList = recipeService.selectStatus(recipeSearch.getStatus(), recipeSearch.getSearchName());
        model.addAttribute("recipeList", recipeList);
        Object member = httpSession.getAttribute("member");
        if(member == null){
            System.out.println("회원정보없음");
            return "/index";
        }else{
        MemberVO memberVo = (MemberVO)member;
        System.out.println(memberVo.getUserId());
        }
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
    public String detailRecipe(Model model , @PathVariable("recipeId")Long recipeId, HttpSession httpSession){
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
        form.setRecommend(recipeVO.getRecommend());

        form.setOriginTag(tagList);
        form.setContent(content);

        model.addAttribute("form",form);

        Object member = httpSession.getAttribute("member");
        MemberVO memberVO = (MemberVO)member;
        if(recipeService.bookmarkCheck(recipeId,memberVO.getId())){
            //없는상태
            model.addAttribute("bookMark","북마크");
        }else {
            model.addAttribute("bookMark", "북마크취소");
        }


        return "recipeDetail";
    }

    @PostMapping("recipe/{recipeId}/favorite")
    public String bookMarkRecipe(@PathVariable("recipeId") Long recipeId, HttpSession httpSession){
        Object member = httpSession.getAttribute("member");
        MemberVO memberVO = (MemberVO)member;
        if(recipeService.bookmarkCheck(recipeId,memberVO.getId())){
            recipeService.insertRecipeBookmark(recipeId,memberVO.getId());
        }else
            recipeService.deleteRecipeBookmark(recipeId,memberVO.getId());

        return "redirect:/recipe/" + recipeId + "/detail";
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
