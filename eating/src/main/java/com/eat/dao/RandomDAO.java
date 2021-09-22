package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eat.vo.EateryVO;
import com.eat.vo.RecipeVO;

@Mapper
public interface RandomDAO {
	List<RecipeVO> showRecipe(@Param("recipeId") Long recipeId);
	List<EateryVO> showEatery(@Param("eateryId") Long eateryId);
	
}
