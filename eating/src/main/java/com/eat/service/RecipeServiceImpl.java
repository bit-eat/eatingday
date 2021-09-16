package com.eat.service;

import com.eat.dao.RecipeContentDAO;
import com.eat.dao.RecipeDAO;
import com.eat.dao.RecipeTagDAO;
import com.eat.vo.People;
import com.eat.vo.RecipeContentVO;
import com.eat.vo.RecipeTagVO;
import com.eat.vo.RecipeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeDAO recipeDAO;
    private final RecipeContentDAO contentDAO;
    private final RecipeTagDAO tagDAO;

    @Override
    public Long saveRecipe(RecipeVO recipe) {
        recipeDAO.insertRecipe(recipe);
        return recipe.getId();
    }

    @Override
    public void saveContent(Long id, RecipeContentVO content) {
        content.setRecipeId(id);
        contentDAO.insertRecipeContent(content);
    }

    @Override
    public void saveTag(Long id, RecipeTagVO tag) {
        tag.setRecipeId(id);
        tagDAO.insertRecipeTag(tag);
    }

    @Override
    public void updateRecipe(RecipeVO recipe) {
        recipeDAO.updateRecipe(recipe);
    }

    @Override
    public void updateContent(RecipeContentVO content) {
        contentDAO.updateRecipeContent(content);
    }

    @Override
    public void updateTag(RecipeTagVO tag) {
        tagDAO.updateRecipeTag(tag);
    }

    @Override
    public void deleteRecipe(Long id) {
        //태그-컨텐츠 cascade 잡아놨으나 수정 필요한지 확인
        recipeDAO.deleteRecipe(id);
    }

    @Override
    public RecipeVO selectOne(Long id) {
        return recipeDAO.selectOne(id);
    }

    @Override
    public List<RecipeVO> selectAll() {
        return recipeDAO.selectAll();
    }

    @Override
    public List<RecipeVO> selectName(String name) {
        return recipeDAO.selectName(name);
    }

    @Override
    public List<RecipeVO> selectPeople(People p) {
        return recipeDAO.selectPeople(p);
    }

    @Override
    public List<RecipeVO> selectIngredient(String ingredient) {
        return null;
    }

    @Override
    public List<RecipeVO> selectUser(String userId) {
        return null;
    }

    @Override
    public List<RecipeVO> selectCategory(String category) {
        return null;
    }

    @Override
    public List<RecipeVO> selectTag(String tagName) {
        List<RecipeTagVO> tagVOList = tagDAO.selectByName(tagName);
        List<RecipeVO> recipeList = new ArrayList<>();

        for(RecipeTagVO vo : tagVOList){
            recipeList.add(recipeDAO.selectOne(vo.getRecipeId()));
        }

        return recipeList;
    }

	@Override
	public void adminRecipedelete(List<Long> id) {  //관리자 레시피 게시판 삭제
		// TODO Auto-generated method stub
		recipeDAO.adminRecipedelete(id);
	}
    
   
}
