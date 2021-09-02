package com.eat.controller;

import com.eat.service.EateryService;
import com.eat.vo.Area;
import com.eat.vo.EateryVO;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

	import java.util.List;

	@Controller
	
	public class EateryController {
		@GetMapping("/")
		    public String insert() {
		    	return "/insert";
		    }
		@GetMapping("/detail")
	    public String deatail() {
	    	return "/detail";
	    }
		@GetMapping("/menu")
	    public String menu() {
	    	return "/menu";
	    }
		
	    @Autowired
	    private EateryService eateryservice;
	    
	    @GetMapping("/insert")
	    public void selectAll(Model model){
	    	System.out.println(eateryservice.selectAll());
	        model.addAttribute("selectAll", eateryservice.selectAll());
	      
	        
	    }

	}

