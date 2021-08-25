package com.eat.dao;

import com.eat.vo.RecipeTagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipeTagDAO {

    void insertRecipeTag(RecipeTagVO tag);

    RecipeTagVO selectOne(@Param("id") Long id);
    RecipeTagVO selectOneByRecipe(@Param("recipeId") Long recipeId, @Param("name") String name);
    List<RecipeTagVO> selectByRecipe(@Param("recipeId") Long recipeId);

    void updateRecipeTag(RecipeTagVO tag);
    void updateTagByRecipe(@Param("recipeId")Long recipeId, @Param("name") String name);

    void deleteTag(@Param("id") Long id);
    void deleteTagByRecipe(@Param("recipeId") Long recipeId, @Param("name") String name);


}
