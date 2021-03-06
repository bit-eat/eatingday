package com.eat.service;


import com.eat.vo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RecipeService {

    Long saveRecipe(RecipeVO recipe);
    void tempSaveContent(Long id, String content);
    void updateRecipe(Long recipeId, String name, String thumb, String ingredient, People p,
                      String originTag, String content);
    void deleteRecipe(Long id);

    boolean bookmarkCheck(Long recipeId, Long memberId);

    Long insertRecipeBookmark(Long recipeId, Long memberId);
    void deleteRecipeBookmark(Long recipeId, Long memberId);

    boolean recommendCheck(Long recipeId, Long memberId);

    Long insertRecipeRecommend(Long recipeId, Long memberId);
    void deleteRecipeRecommend(Long recipeId, Long memberId);

    RecipeVO selectOne(Long id);
    List<RecipeVO> selectAll();

    List<RecipeVO> selectStatus(SearchStatus status, String name);

    List<RecipeVO> selectName(String name);
    List<RecipeVO> selectIngredient(String ingredient);
    List<RecipeVO> selectTag(String tagName);

    void manufactureTag(Long recipeId, String originTag);
    String combineTag(Long recipeId);

    RecipeContentVO selectContent(Long recipeId);


   
}
