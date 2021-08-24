package com.eat.controller.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.eat.dao.suggestion.CategoryDAO;
import com.eat.vo.suggestion.CategoryVO;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;

	public void insertCategory(CategoryVO categoryVO) {

	}

	public void deleteCategory(Long id) {

	}

	public List<CategoryVO> categoryList() {
		
		return categoryDAO.categoryList();
	}

}
