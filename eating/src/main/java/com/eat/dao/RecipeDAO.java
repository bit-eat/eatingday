package com.eat.dao;

import com.eat.vo.People;
import com.eat.vo.RecipeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipeDAO {

    Long insertRecipe(RecipeVO recipe);

    RecipeVO selectOne(@Param("id") Long id);
    List<RecipeVO> selectAll();

    List<RecipeVO> selectName(@Param("name") String name);
    List<RecipeVO> selectPeople(@Param("people") People p);
    List<RecipeVO> selectIngredient(@Param("ingredient") String ingredient);
    List<RecipeVO> selectCategory(@Param("category") String category);


    void updateRecipe(RecipeVO recipe);
    void deleteRecipe(@Param("id") Long id);


}
