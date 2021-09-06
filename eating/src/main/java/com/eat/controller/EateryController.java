package com.eat.controller;

import com.eat.service.EateryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


	@Controller
	
	public class EateryController {
		@GetMapping("/eatery")
		public String insert() {
		    return "/insert";
		    }
		@GetMapping("/eatery/eateryMain")
	    public String eateryMain() {
	    	return "/eateryMain";
	    }
		@GetMapping("/eatery/detail")
	    public String deatail() {
	    	return "/detail";
	    }
		@GetMapping("/eatery/menu")
	    public String menu() {
	    	return "/menu";
	    }
		
	    @Autowired
	    private EateryService eateryservice;
	    
	    @RequestMapping(value="/insertPost")
	    public void selectAll(Model model){
	    	System.out.println(eateryservice.selectAll());
	        model.addAttribute("selectAll", eateryservice.selectAll());
	      
	    }

	}