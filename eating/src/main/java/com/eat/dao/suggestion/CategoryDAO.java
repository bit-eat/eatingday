package com.eat.dao.suggestion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.eat.vo.suggestion.CategoryVO;

@Mapper
public interface CategoryDAO {
	public void insertCategory(CategoryVO categoryVO);
	public void deleteCategory(Long id);
	
	@Select("select * from category")
	List<CategoryVO> categoryList();
}
