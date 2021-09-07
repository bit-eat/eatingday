package com.eat.dao;

import com.eat.vo.RecipeContentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipeContentDAO {

    void insertRecipeContent(RecipeContentVO content);

    RecipeContentVO selectOne(@Param("recipeId") Long recipeId, @Param("turn") int turn);
    List<RecipeContentVO> selectByRecipe(@Param("recipeId") Long recipeId);

    void updateRecipeContent(RecipeContentVO content);

    void deleteTurn(@Param("recipeId")Long recipeId, @Param("turn") int turn);
    void deleteRecipeContent(@Param("id") Long id);

}
