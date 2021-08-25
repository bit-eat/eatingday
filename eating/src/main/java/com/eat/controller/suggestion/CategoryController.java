package com.eat.controller.suggestion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eat.dao.suggestion.CategoryDAO;
import com.eat.vo.suggestion.CategoryVO;

@Controller
public class CategoryController {
	
	@GetMapping("/")
	public String main() {
	
		return "/main";
	}
	
	@Autowired(required=false)
	CategoryDAO categoryDAO;

	public void insertCategory(CategoryVO categoryVO) {

	}

	public void deleteCategory(Long id) {

	}
	
	@GetMapping("/main")
	public String categoryList(Model model) {
		List<CategoryVO> cate = categoryDAO.categoryList();
		model.addAttribute(cate);
		System.out.println(cate);
		System.out.println(model);
		return "/main";
	}

}
