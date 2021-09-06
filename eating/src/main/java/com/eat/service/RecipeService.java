package com.eat.service;


import com.eat.vo.People;
import com.eat.vo.RecipeContentVO;
import com.eat.vo.RecipeTagVO;
import com.eat.vo.RecipeVO;

import java.util.List;

public interface RecipeService {

    Long saveRecipe(RecipeVO recipe);
    void saveContent(Long id, RecipeContentVO content);
    void saveTag(Long id, RecipeTagVO tag);
    void updateRecipe(RecipeVO recipe);
    void updateContent(RecipeContentVO content);
    void updateTag(RecipeTagVO tag);
    void deleteRecipe(Long id);

    RecipeVO selectOne(Long id);
    List<RecipeVO> selectAll();

    List<RecipeVO> selectName(String name);
    List<RecipeVO> selectPeople(People p);
    List<RecipeVO> selectIngredient(String ingredient);

    List<RecipeVO> selectUser(String userId);
    List<RecipeVO> selectCategory(String category);
    List<RecipeVO> selectTag(String tagName);


}
