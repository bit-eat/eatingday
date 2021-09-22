package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eat.vo.CategoryVO;

@Mapper
public interface CategoryDAO {
	public void insertCategory(CategoryVO categoryVO);
	public void updateCategory(CategoryVO categoryVO);
	public void deleteCategory(Long id);

	CategoryVO selectName(@Param("name")String name);
	CategoryVO selectId(@Param("id")Long id);


	List<CategoryVO> categoryList();
	
}