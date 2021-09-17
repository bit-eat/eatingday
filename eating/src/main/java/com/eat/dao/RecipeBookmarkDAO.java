package com.eat.dao;

import com.eat.vo.RecipeBookmarkVO;
import com.eat.vo.RecipeVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipeBookmarkDAO {

    void insertRecipeBookmark(RecipeBookmarkVO recipebookmarkvo);
    
    List<RecipeBookmarkVO> selectMemberId(@Param("name") String name);
    
    List<RecipeBookmarkVO> selectRecipeBookmark(@Param("id") Long id);
    
    void deleteRecipeBookmark(@Param("id") Long id);

}
