package com.eat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.CategoryDAO;
import com.eat.vo.CategoryVO;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
//	
//	@GetMapping("/")
//	public String main() {
//		return "/main";
//	}
//	
//	
//	@GetMapping("/aa")
//	public List<CategoryVO> categoryList() {
//		System.out.println(categoryDAO.categoryList());
//		return categoryDAO.categoryList();
//	}

}
