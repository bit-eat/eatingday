package com.eat.dao;

import com.eat.vo.People;
import com.eat.vo.RecipeBookmarkVO;
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
    List<RecipeVO> selectCategoryId(@Param("category") Long categoryId);
    List<RecipeVO> selectMemberId(@Param("member")Long memberId);

    void updateRecipe(RecipeVO recipe);
    void deleteRecipe(@Param("id") Long id);

    void addRecommend(@Param("id") Long recipeId);
    void removeRecommend(@Param("id") Long recipeId);

    Long insertRecipeBookmark(RecipeBookmarkVO bookmarkVO);
    void deleteRecipeBookmark(@Param("recipeId")Long recipeId, @Param("memberId")Long memberId);

    Long selectBookmark(@Param("recipeId") Long recipeId ,@Param("memberId") Long memberId);
    RecipeVO bookmarkCheck(@Param("recipeId") Long recipeId ,@Param("memberId") Long memberId);

	void adminRecipedelete(@Param("id")List<Long> id);   //관리자 레시피 게시판 관리

}
