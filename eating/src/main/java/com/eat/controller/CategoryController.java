package com.eat.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.CategoryDAO;
import com.eat.vo.CategoryVO;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public void insertCategory(CategoryVO CategoryVO) {
		
	}
	public void updateCategory(CategoryVO CategoryVO) {
		
	};
	public void deleteCategory(Long id) {
		
	};
	
	
//	
//	@GetMapping("/")
//	public String main() {
//		return "/main";
//	}
//	
//	
//	@GetMapping("/dietList")
//	public void categoryList(Model model) {
//		System.out.println(categoryDAO.categoryList());
//		model.addAttribute( "categoryList"  , categoryDAO.categoryList());
//	}

}
