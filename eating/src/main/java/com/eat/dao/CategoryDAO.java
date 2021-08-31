package com.eat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eat.vo.CategoryVO;

@Mapper
public interface CategoryDAO {
	public void insertCategory(CategoryVO categoryVO);
	
	public void deleteCategory(Long id);
	
	List<CategoryVO> categoryList();
}