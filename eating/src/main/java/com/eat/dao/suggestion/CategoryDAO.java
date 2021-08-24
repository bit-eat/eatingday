package com.eat.dao.suggestion;

import java.util.List;

import com.eat.vo.suggestion.CategoryVO;

public interface CategoryDAO {
	public void insertCategory(CategoryVO categoryVO);
	public void deleteCategory(Long id);
	public List<CategoryVO> categoryList();
}
